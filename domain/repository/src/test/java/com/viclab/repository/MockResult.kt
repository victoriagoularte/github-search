package com.viclab.repository

import com.viclab.model.repository.Owner
import com.viclab.model.repository.Repository
import com.viclab.model.repository.RepositoryList

object MockResult {

    fun fakeRepositoryList() = RepositoryList(
        repositoryList = listOf(
            fakeRepository()
        )
    )

    fun fakeRepository() = Repository(
        name = "kotlin",
        score = 1345,
        forks = 5451,
        owner =  fakeOwner()
    )

    fun fakeOwner() = Owner(
        login = "JetBrains",
        avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4"
    )

}