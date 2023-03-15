package com.viclab.repository.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.viclab.model.repository.Repository
import com.viclab.repository.datasource.RepositoryPagingSource
import com.viclab.repository.datasource.RepositoryRemoteDataSource
import com.viclab.repository.model.mapper.asRepository
import com.viclab.repository.model.mapper.asRepositoryList
import com.viclab.repository.model.response.RepositoryListResponse
import com.viclab.repository.model.response.RepositoryResponse
import com.viclab.repository.remote.RepositoryService
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class RepoRepositoryImpl @Inject constructor(private val service: RepositoryService) : RepoRepository {

    override fun repositories(
        language: String,
        sort: String,
        page: Int,
        perPage: Int
    ) = Pager(
        config = PagingConfig(
            pageSize = 10,
        ),
        pagingSourceFactory = { RepositoryPagingSource(service) }
    ).flow.map { pagingData -> pagingData.map { it.asRepository() } }
}
