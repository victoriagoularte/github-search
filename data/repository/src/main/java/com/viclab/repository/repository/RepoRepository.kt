package com.viclab.repository.repository

import androidx.paging.PagingData
import com.viclab.model.repository.Repository
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    fun repositories(language: String, sort: String) : Flow<PagingData<Repository>>
}