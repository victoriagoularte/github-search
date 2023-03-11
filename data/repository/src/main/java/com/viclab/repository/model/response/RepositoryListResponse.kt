package com.viclab.repository.model.response

import com.google.gson.annotations.SerializedName

data class RepositoryListResponse(
    @SerializedName("items")
    val repositoryList: List<RepositoryResponse>
)
