package com.viclab.repository.model.response

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("stargazers_count")
    val score: Float,
    @SerializedName("forks")
    val forks: Int,
    @SerializedName("owner")
    val owner: OwnerResponse,
)
