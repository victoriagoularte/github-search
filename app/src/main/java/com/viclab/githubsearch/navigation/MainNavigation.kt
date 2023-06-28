package com.viclab.githubsearch.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.viclab.repository.search.SearchScreen
import com.viclab.repository.search.viewmodel.SearchRepositoryViewModel


const val searchRepositoryRoute = "search_repository_route"

fun NavController.navigateSearchRepository(navOptions: NavOptions? = null) {
    this.navigate(searchRepositoryRoute, navOptions)
}

fun NavGraphBuilder.searchRepositoryGraph() {
    composable(route = searchRepositoryRoute) {
        val viewModel: SearchRepositoryViewModel = hiltViewModel()
        SearchScreen(viewModel.repositories())
    }
}