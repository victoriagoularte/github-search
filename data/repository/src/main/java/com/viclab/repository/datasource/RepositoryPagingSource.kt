package com.viclab.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.viclab.model.repository.Repository
import com.viclab.repository.model.response.RepositoryResponse
import com.viclab.repository.remote.RepositoryService

internal class RepositoryPagingSource(
    private val service: RepositoryService,
): PagingSource<Int, RepositoryResponse>() {

    override fun getRefreshKey(state: PagingState<Int, RepositoryResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RepositoryResponse> {
        return try {
            val page = params.key ?: 1
            val response = service.repositories(page = page)

            LoadResult.Page(
                data = response.repositoryList,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.repositoryList.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}