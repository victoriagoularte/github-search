package com.viclab.repository.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.viclab.database.GithubSearchDatabase
import com.viclab.database.model.RemoteKeysEntity
import com.viclab.database.model.RepositoryEntity
import com.viclab.repository.datasource.remote.RepositoryRemoteDataSource
import com.viclab.repository.model.mapper.asRepositoryEntity
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit

const val ITEMS_PER_PAGE = 15
private const val ONE_PAGE = 1
private const val ONE_KEY = 1
private const val SOURCE_DURATION = 1L

@OptIn(ExperimentalPagingApi::class)
class PageRepositoryRemoteMediator (
    private val remoteDataSource: RepositoryRemoteDataSource,
    private val database: GithubSearchDatabase,
): RemoteMediator<Int, RepositoryEntity>() {

    var language = ""
    var sort = ""

    override suspend fun initialize(): InitializeAction {
        val cacheTimeout = TimeUnit.MILLISECONDS.convert(SOURCE_DURATION, TimeUnit.HOURS)

        return if (System.currentTimeMillis() - (database.remoteKeysDao().getCreationTime() ?: 0) < cacheTimeout) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, RepositoryEntity>): RemoteKeysEntity? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let { repository ->
            database.remoteKeysDao().getRemoteKeyByRepositoryId(repository.id)
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, RepositoryEntity>): RemoteKeysEntity? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()?.let { repository ->
            database.remoteKeysDao().getRemoteKeyByRepositoryId(repository.id)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, RepositoryEntity>): RemoteKeysEntity? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                database.remoteKeysDao().getRemoteKeyByRepositoryId(id)
            }
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, RepositoryEntity>
    ): MediatorResult {
        val page: Int = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(ONE_KEY) ?: ONE_KEY
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey
                prevKey ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                nextKey ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }
        }

        try {
            val apiResponse = remoteDataSource.repositories(language = language, sort = sort, page = page, ITEMS_PER_PAGE)
//            delay(1000L)
            val repositories = apiResponse.repositoryList
            val endOfPaginationReached = repositories.isEmpty()

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.remoteKeysDao().clearRemoteKeys()
                    database.repositoryDao().clearRepositories()
                }
                val prevKey = if (page > ONE_PAGE) page - ONE_PAGE else null
                val nextKey = if (endOfPaginationReached) null else page + ONE_PAGE
                val remoteKeys = repositories.map {
                    RemoteKeysEntity(repositoryId = it.id, prevKey = prevKey, currentPage = page, nextKey = nextKey)
                }

                database.remoteKeysDao().insertAll(remoteKeys)
                val repositoryEntities = repositories.map { it.asRepositoryEntity() }

                database.repositoryDao().insertAll(
                    repositoryEntities.onEachIndexed { _, repository -> repository.page = page })
            }

            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (error: IOException) {
            return MediatorResult.Error(error)
        } catch (error: HttpException) {
            return MediatorResult.Error(error)
        }
    }
}