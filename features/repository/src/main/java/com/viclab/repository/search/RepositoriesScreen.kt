package com.viclab.repository.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.viclab.repository.search.viewmodel.SearchRepositoryViewModel
import com.viclab.ui.components.RepositoryCardList
import com.viclab.ui.theme.GithubSearchTheme

@Composable
fun SearchScreen(
    viewModel: SearchRepositoryViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val repositories = viewModel.repositories().collectAsLazyPagingItems()
    RepositoryCardList(repositoryList = repositories)

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GithubSearchTheme {
        SearchScreen()
    }
}