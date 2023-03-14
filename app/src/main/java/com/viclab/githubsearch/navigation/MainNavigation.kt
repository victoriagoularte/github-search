package com.viclab.githubsearch.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.viclab.repository.search.SearchScreen


const val searchRepositoryRoute = "search_repository_route"

fun NavController.navigateSearchRepository(navOptions: NavOptions? = null) {
    this.navigate(searchRepositoryRoute, navOptions)
}

fun NavGraphBuilder.searchRepositoryGraph() {
    composable(route = searchRepositoryRoute) {
        SearchScreen()
    }
}