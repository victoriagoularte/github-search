package com.viclab.repository

import com.viclab.model.repository.Owner
import com.viclab.model.repository.Repository
import com.viclab.model.repository.RepositoryList
import com.viclab.repository.model.response.OwnerResponse
import com.viclab.repository.model.response.RepositoryListResponse
import com.viclab.repository.model.response.RepositoryResponse

object MockResponse {

    fun fakeRepositoryList() = RepositoryList(
        repositoryList = listOf(
            fakeRepository()
        )
    )

    fun fakeRepository() = Repository(
        name = "kotlin",
        score = 1.0f,
        forks = 5451,
        owner =  fakeOwner()
    )

    fun fakeOwner() = Owner(
        login = "JetBrains",
        avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4"
    )

}