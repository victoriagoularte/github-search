package com.viclab.repository.model.mapper

import com.viclab.model.repository.Owner
import com.viclab.repository.model.response.OwnerResponse

fun OwnerResponse.asOwner() = Owner(
    login = login,
    avatarUrl = avatarUrl,
)