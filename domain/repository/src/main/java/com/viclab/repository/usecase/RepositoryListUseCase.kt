package com.viclab.repository.usecase

import com.viclab.repository.repository.RepoRepository
import javax.inject.Inject

class RepositoryListUseCase @Inject constructor(private val repository: RepoRepository) {

    operator fun invoke(language: String, sort: String, page: Int, perPage: Int) =
        repository.repositories(language, sort, page, perPage)
}