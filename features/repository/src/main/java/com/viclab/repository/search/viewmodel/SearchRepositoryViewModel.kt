package com.viclab.repository.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.viclab.core.coroutines.di.DispatchersIo
import com.viclab.repository.usecase.RepositoryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SearchRepositoryViewModel @Inject constructor(
    private val useCase: RepositoryListUseCase,
    @DispatchersIo private val dispatcher: CoroutineDispatcher
): ViewModel() {

    fun repositories() =
        useCase("java", "stars").flowOn(dispatcher).stateIn(viewModelScope, SharingStarted.Eagerly, PagingData.empty())

}