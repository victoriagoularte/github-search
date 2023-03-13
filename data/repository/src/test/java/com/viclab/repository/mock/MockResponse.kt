package com.viclab.repository.mock

import com.viclab.repository.model.response.OwnerResponse
import com.viclab.repository.model.response.RepositoryListResponse
import com.viclab.repository.model.response.RepositoryResponse

object MockResponse {

    fun fakeRepositoryListResponse() = RepositoryListResponse(
        repositoryList = listOf(
            fakeRepositoryResponse()
        )
    )

    fun fakeRepositoryResponse() = RepositoryResponse(
        name = "JetBrains/kotlin",
        score = 1.0f,
        forks = 5451,
        owner =  fakeOwnerReponse()
    )

    fun fakeOwnerReponse() = OwnerResponse(
        login = "JetBrains",
        avatarUrl = "https://avatars.githubusercontent.com/u/878437?v=4"
    )

}