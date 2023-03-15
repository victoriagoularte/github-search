package com.viclab.repository.search.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.viclab.core.viewmodel.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchRepositoryViewModel @Inject constructor(
    private val pagingSource: RepositoryPagingSource,
): ViewModel<SearchRepositoryState, SearchRepositoryAction>(
    SearchRepositoryState()
) {

    private val pager = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { pagingSource }
    )

    val getRepositories = pager.flow.cachedIn(viewModelScope)
}