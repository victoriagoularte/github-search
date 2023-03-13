package com.viclab.domain.usecase

import com.viclab.model.repository.Owner
import com.viclab.model.repository.Repository
import com.viclab.model.repository.RepositoryList
import com.viclab.repository.model.response.OwnerResponse

object MockResponse {

    fun fakeRepositoryList() = RepositoryList(
        repositoryList = listOf(
            fakeRepository()
        )
    )

    fun fakeRepository() = Repository(
        name = "JetBrains/kotlin",
        score = 1.0f,

        forks = 5451,
        owner =  fakeOwner()
    )

    fun fakeOwner() = Owner(
        login = "JetBrains",
        avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4"
    )

}