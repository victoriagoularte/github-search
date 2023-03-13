package com.viclab.repository.model.mapper

import com.viclab.model.repository.Owner
import com.viclab.model.repository.Repository
import com.viclab.model.repository.RepositoryList
import com.viclab.repository.model.response.OwnerResponse
import com.viclab.repository.model.response.RepositoryListResponse
import com.viclab.repository.model.response.RepositoryResponse

fun RepositoryListResponse.asRepositoryList() = RepositoryList(
    repositoryList = repositoryList.map(RepositoryResponse::asRepository)
)
