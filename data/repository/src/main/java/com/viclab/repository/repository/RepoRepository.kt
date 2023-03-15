package com.viclab.repository.repository

import androidx.paging.PagingData
import com.viclab.model.repository.Repository
import com.viclab.model.repository.RepositoryList
import kotlinx.coroutines.flow.Flow

interface RepoRepository {

    fun repositories(language: String, sort: String, page: Int, perPage: Int) :Flow<PagingData<Repository>>
}