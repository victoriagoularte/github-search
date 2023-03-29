package com.viclab.repository.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.viclab.database.GithubSearchDatabase
import com.viclab.model.repository.Repository
import com.viclab.repository.datasource.remote.RepositoryRemoteDataSource
import com.viclab.repository.model.mapper.asRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RepositoryRemoteDataSource,
    private val localDataSource: GithubSearchDatabase,
) : RepoRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun repositories(
        language: String,
        sort: String
    ): Flow<PagingData<Repository>> = Pager(
            config = PagingConfig(
                pageSize = ITEMS_PER_PAGE,
                prefetchDistance = 10,
                initialLoadSize = ITEMS_PER_PAGE,
            ),
            pagingSourceFactory = {
                localDataSource.repositoryDao().getRepositoryList()
            },
            remoteMediator = PageRepositoryRemoteMediator(
                remoteDataSource,
                localDataSource,
            )
        ).flow.map { pagingData -> pagingData.map { it.asRepository() } }
}
