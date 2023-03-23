package com.viclab.repository.repository

import com.viclab.repository.datasource.RepositoryRemoteDataSource
import com.viclab.repository.model.mapper.asRepository
import com.viclab.repository.model.response.RepositoryResponse
import javax.inject.Inject

internal class RepoRepositoryImpl @Inject constructor(private val dataSource: RepositoryRemoteDataSource) : RepoRepository {

    override suspend fun repositories(
        language: String,
        sort: String,
        page: Int,
        perPage: Int
    ) = dataSource.repositories(language, sort, page, perPage).repositoryList.map(RepositoryResponse::asRepository)
}
