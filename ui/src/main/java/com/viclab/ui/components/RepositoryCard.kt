package com.viclab.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ForkLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.viclab.ui.theme.GithubSearchTheme

@Composable
fun RepositoryCard(
    name: String,
    login: String,
    avatarUrl: String,
    stars: Float,
    forks: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.surface),
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(avatarUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape).size(32.dp)
            )
            Text(modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth(),
                text = "${login}/${name}")
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Row(modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Estrelas")
                Text(text = stars.toInt().toString(), modifier = Modifier.padding(start = 8.dp))
            }
            Row(modifier = Modifier.padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.ForkLeft, contentDescription = "Forks")
                Text(text = forks.toString(), modifier = Modifier.padding(start = 4.dp))
            }
        }
    }
}

@Preview(name = "RepositoryCard")
@Composable
private fun PreviewRepositoryCard() {
    GithubSearchTheme {
        RepositoryCard("Teste", "Teste", "Teste", 1f, 1000)
    }
}