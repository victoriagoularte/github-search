package com.viclab.repository.datasource

import com.viclab.repository.model.response.RepositoryListResponse
import kotlinx.coroutines.flow.Flow

interface RepositoryRemoteDataSource {

    fun repositories(language: String, sort: String, page: Int, perPage: Int) : Flow<RepositoryListResponse>
}