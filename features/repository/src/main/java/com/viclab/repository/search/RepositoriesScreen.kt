package com.viclab.repository.search

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.viclab.ui.components.RepositoryCardList
import com.viclab.ui.components.getRepositoryList
import com.viclab.ui.theme.GithubSearchTheme

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier) {

    Column(modifier = modifier
        .verticalScroll(rememberScrollState())
    ) {
        RepositoryCardList(repositoryList = getRepositoryList())
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GithubSearchTheme {
        SearchScreen()
    }
}