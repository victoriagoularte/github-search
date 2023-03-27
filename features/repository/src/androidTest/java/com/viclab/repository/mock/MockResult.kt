package com.viclab.repository.mock

import com.viclab.model.repository.Owner
import com.viclab.model.repository.Repository
import com.viclab.model.repository.RepositoryList

object MockResult {

    fun fakeRepositoryList() = RepositoryList(
        repositoryList = listOf(
            fakeRepositoryFirst(),
            fakeRepositorySecond(),
        )
    )

    fun fakeRepositoryFirst() = Repository(
        name = "sunflower",
        score = 16659,
        forks = 4402,
        owner =  fakeOwnerFirst()
    )

    fun fakeRepositorySecond() = Repository(
        name = "plaid",
        score = 16245,
        forks = 3233,
        owner =  fakeOwnerSecond()
    )

    fun fakeOwnerFirst() = Owner(
        login = "android",
        avatarUrl = "https://avatars.githubusercontent.com/u/32689599?v=4"
    )

    fun fakeOwnerSecond() = Owner(
        login = "nickbutcher",
        avatarUrl = "https://avatars.githubusercontent.com/u/352556?v=4"
    )

}