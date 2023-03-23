package com.viclab.repository.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.viclab.core.coroutines.di.DispatchersIo
import com.viclab.repository.search.ITEMS_PER_PAGE
import com.viclab.repository.search.RepositoriesPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class SearchRepositoryViewModel @Inject constructor(
    private val repositoriesPagingSource: RepositoriesPagingSource,
    @DispatchersIo private val dispatcher: CoroutineDispatcher
): ViewModel() {

    private val pagingData = Pager(
        config = PagingConfig(ITEMS_PER_PAGE),
        pagingSourceFactory = {
            repositoriesPagingSource.apply {
                language = "kotlin"
                sort = "stars"
            }
        }
    ).flow

    fun repositories() = pagingData.cachedIn(viewModelScope).flowOn(dispatcher)
}