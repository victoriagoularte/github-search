package com.viclab.repository.datasource.remote

import com.viclab.repository.remote.RepositoryService
import javax.inject.Inject

internal class RepositoryRemoteDataSourceImpl @Inject constructor(private val service: RepositoryService)
    : RepositoryRemoteDataSource {

    override suspend fun repositories(
        language: String,
        sort: String,
        page: Int,
        perPage: Int
    ) = service.repositories(language, sort, page, perPage)

}