package com.viclab.repository.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.viclab.model.repository.Owner
import com.viclab.model.repository.Repository
import com.viclab.model.repository.RepositoryList
import com.viclab.ui.components.RepositoryCardList
import com.viclab.ui.theme.GithubSearchTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun SearchScreen(
    repositories: StateFlow<PagingData<Repository>>,
    modifier: Modifier = Modifier
) {
    val repositories = repositories.collectAsLazyPagingItems()
    RepositoryCardList(repositoryList = repositories)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GithubSearchTheme {
        val repositories: StateFlow<PagingData<Repository>> =
            MutableStateFlow(
                PagingData.from(fakeRepositoryList().repositoryList)
            )
        SearchScreen(repositories)
    }
}

fun fakeRepositoryList() = RepositoryList(
    repositoryList = listOf(
        fakeRepository()
    )
)

fun fakeRepository() = Repository(
    id = 1,
    name = "kotlin",
    score = 1345,
    forks = 5451,
    owner =  fakeOwner()
)

fun fakeOwner() = Owner(
    login = "JetBrains",
    avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4"
)