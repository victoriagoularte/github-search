package com.viclab.repository.search

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.viclab.model.repository.Repository
import com.viclab.repository.usecase.RepositoryListUseCase
import javax.inject.Inject
import javax.inject.Named

private const val FIRST_PAGE_INDEX = 1
private const val ONE = 1
const val ITEMS_PER_PAGE = 15

class RepositoriesPagingSource @Inject constructor(
    @Named("language") var language: String,
    @Named("sort") var sort: String,
    private val useCase: RepositoryListUseCase
) : PagingSource<Int, Repository>() {

    override fun getRefreshKey(state: PagingState<Int, Repository>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(ONE)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(ONE)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repository> {
        return try {
            val page = params.key ?: FIRST_PAGE_INDEX
            val result = useCase(language = language, sort = sort, page = page, ITEMS_PER_PAGE)

            LoadResult.Page(
                data = result,
                prevKey = if (page == FIRST_PAGE_INDEX) null else page.minus(ONE),
                nextKey = if (result.isEmpty()) null else page.plus(ONE),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}
