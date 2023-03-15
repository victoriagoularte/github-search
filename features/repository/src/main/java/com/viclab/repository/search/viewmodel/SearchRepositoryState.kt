package com.viclab.repository.search.viewmodel

import com.viclab.core.viewmodel.UIState

data class SearchRepositoryState(
    val isLoading: Boolean = false,
) : UIState
