package com.viclab.repository.repository

import com.viclab.model.repository.RepositoryList
import kotlinx.coroutines.flow.Flow

interface RepoRepository {

    fun repositories(language: String, sort: String, page: Int, perPage: Int) : Flow<RepositoryList>
}