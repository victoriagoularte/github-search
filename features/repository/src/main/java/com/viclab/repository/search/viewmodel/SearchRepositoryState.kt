package com.viclab.repository.search.viewmodel

import com.viclab.core.viewmodel.UIState
import com.viclab.model.repository.Repository

data class SearchRepositoryState(
    val isLoading: Boolean = true,
    val repositoryList: List<Repository> = emptyList(),
    val hasError: Boolean = false,
) : UIState {
    fun updateList(repositoryList: List<Repository>) = copy(isLoading = false, repositoryList = repositoryList, hasError = false)
    fun showError() = copy(isLoading = false, repositoryList = emptyList(), hasError = true)
}
