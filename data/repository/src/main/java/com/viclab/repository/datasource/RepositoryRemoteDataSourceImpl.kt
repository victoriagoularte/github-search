package com.viclab.repository.datasource

import com.viclab.repository.model.response.RepositoryListResponse
import com.viclab.repository.remote.RepositoryService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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