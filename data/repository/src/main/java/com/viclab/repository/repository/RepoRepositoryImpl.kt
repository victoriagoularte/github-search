package com.viclab.repository.repository

import com.viclab.repository.datasource.RepositoryRemoteDataSource
import com.viclab.repository.model.mapper.asRepositoryList
import com.viclab.repository.model.response.RepositoryListResponse
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(val dataSource: RepositoryRemoteDataSource) : RepoRepository {

    override fun repositories(
        language: String,
        sort: String,
        page: Int,
        perPage: Int
    ) = (dataSource.repositories(language, sort, page, perPage).map(RepositoryListResponse::asRepositoryList))

}
