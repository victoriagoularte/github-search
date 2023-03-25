package com.viclab.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.viclab.model.repository.Owner
import com.viclab.model.repository.Repository
import com.viclab.model.repository.RepositoryList
import com.viclab.ui.R
import com.viclab.ui.theme.GithubSearchTheme

@Composable
fun RepositoryCardList(
    repositoryList: LazyPagingItems<Repository>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(repositoryList) { repository ->
            repository?.let {
                RepositoryCard(
                    name = it.name,
                    login = it.owner.login,
                    avatarUrl = it.owner.avatarUrl,
                    stars = it.score,
                    forks = it.forks)
                Divider(color = MaterialTheme.colorScheme.secondary, thickness = 1.dp)
            }
        }

        when(repositoryList.loadState.refresh) {
            is LoadState.Error -> {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colorScheme.background),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(R.string.error_message),
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }

            }
            is LoadState.Loading -> {
                item {
                    Column(
                        modifier = Modifier
                            .fillParentMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(8.dp),
                            text = stringResource(R.string.loading_message)
                        )

                        CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                    }
                }
            }
            else -> {}
        }

        when (val state = repositoryList.loadState.append) { // Pagination
            is LoadState.Error -> {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colorScheme.background),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(R.string.error_message),
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
            is LoadState.Loading -> { // Pagination Loading UI
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(text = stringResource(R.string.loading_pagination_message))
                        CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                    }
                }
            }
            else -> {}
        }
    }
}

@Preview
@Composable
fun RepositoryCardListPreview() {
    GithubSearchTheme() {

//        RepositoryCardList(repositoryList = getRepositoryList())
    }
}

fun getRepositoryList() = RepositoryList(
    repositoryList = listOf(
        Repository(
            name = "githubsearch",
            score = 5f,
            forks = 129,
            owner = Owner(
                login = "vicgoularte",
                avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4"
            )
        ),
        Repository(
            name = "githubsearch",
            score = 5f,
            forks = 129,
            owner = Owner(
                login = "vicgoularte",
                avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4"
            )
        ),
        Repository(
            name = "githubsearch",
            score = 5f,
            forks = 129,
            owner = Owner(
                login = "vicgoularte",
                avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4"
            )
        ),
        Repository(
            name = "githubsearch",
            score = 5f,
            forks = 129,
            owner = Owner(
                login = "vicgoularte",
                avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4"
            )
        )
    )
)
