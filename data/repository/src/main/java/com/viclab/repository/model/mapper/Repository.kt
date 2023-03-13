package com.viclab.repository.model.mapper

import com.viclab.model.repository.Repository
import com.viclab.repository.model.response.RepositoryResponse

fun RepositoryResponse.asRepository() = Repository(
    name = name,
    score = score,
    forks = forks,
    owner = owner.asOwner()
)