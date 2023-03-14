package com.viclab.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.viclab.model.repository.Owner
import com.viclab.model.repository.Repository
import com.viclab.model.repository.RepositoryList
import com.viclab.ui.theme.GithubSearchTheme

@Composable
fun RepositoryCardList(
    repositoryList: RepositoryList,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(16.dp)
            .border(
                BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.secondary),
                shape = RoundedCornerShape(15.dp)
            )
    ) {
        items(repositoryList.repositoryList) {repository ->
            RepositoryCard(login = repository.name, stars = repository.score, forks = repository.forks)
            Divider(color = MaterialTheme.colorScheme.secondary, thickness = 2.dp)
        }
    }
}

@Preview(name = "RepositoryCardList")
@Composable
private fun PreviewRepositoryCardList() {
    GithubSearchTheme {
        RepositoryCardList(getRepositoryList())
    }
}

fun getRepositoryList() = RepositoryList(
    repositoryList = listOf(
        Repository(
            name = "vic/githubsearch",
            score = 5f,
            forks = 129,
            owner = Owner(
                login = "vicgoularte",
                avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4"
            )
        ),
        Repository(
            name = "vic/githubsearch",
            score = 5f,
            forks = 129,
            owner = Owner(
                login = "vicgoularte",
                avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4"
            )
        ),
        Repository(
            name = "vic/githubsearch",
            score = 5f,
            forks = 129,
            owner = Owner(
                login = "vicgoularte",
                avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4"
            )
        ),
        Repository(
            name = "vic/githubsearch",
            score = 5f,
            forks = 129,
            owner = Owner(
                login = "vicgoularte",
                avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4"
            )
        )
    )
)