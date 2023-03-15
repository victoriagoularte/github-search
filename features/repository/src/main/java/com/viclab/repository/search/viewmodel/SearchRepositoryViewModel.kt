package com.viclab.repository.search.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.viclab.core.viewmodel.ViewModel
import com.viclab.model.repository.Repository
import com.viclab.repository.usecase.RepositoryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SearchRepositoryViewModel @Inject constructor(
    private val useCase: RepositoryListUseCase,
): androidx.lifecycle.ViewModel() {

    fun repositories(): Flow<PagingData<Repository>> = useCase("kotlin", "stars", 1, 10).cachedIn(viewModelScope)
}