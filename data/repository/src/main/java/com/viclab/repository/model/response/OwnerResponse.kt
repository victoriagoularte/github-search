package com.viclab.repository.model.response

import com.google.gson.annotations.SerializedName

data class OwnerResponse (
    @SerializedName("id")
    val id: Long,
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
)
