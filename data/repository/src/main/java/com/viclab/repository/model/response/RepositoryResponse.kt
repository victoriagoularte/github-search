package com.viclab.repository.model.response

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("full_name")
    val name: String,
    @SerializedName("score")
    val score: Float,
    @SerializedName("forks")
    val forks: Int,
    @SerializedName("owner")
    val owner: OwnerResponse,
)
