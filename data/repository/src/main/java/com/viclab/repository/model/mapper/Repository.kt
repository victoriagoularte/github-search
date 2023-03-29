package com.viclab.repository.model.mapper

import com.viclab.database.model.RepositoryEntity
import com.viclab.model.repository.Owner
import com.viclab.model.repository.Repository
import com.viclab.repository.model.response.RepositoryResponse

fun RepositoryResponse.asRepository() = Repository(
    id = id,
    name = name,
    score = score,
    forks = forks,
    owner = owner.asOwner()
)

fun RepositoryResponse.asRepositoryEntity() = RepositoryEntity(
    id = id,
    name = name,
    stars = score,
    forks = forks,
    login = owner.login,
    avatarUrl = owner.avatarUrl
)

fun RepositoryEntity.asRepository() = Repository(
    id = id,
    name = name,
    score = stars,
    forks = forks,
    owner = Owner(
        login = login,
        avatarUrl = avatarUrl
    )
)
