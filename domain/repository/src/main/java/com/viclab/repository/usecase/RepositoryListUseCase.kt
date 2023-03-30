package com.viclab.repository.usecase

import com.viclab.repository.repository.RepoRepository
import javax.inject.Inject

class RepositoryListUseCase @Inject constructor(private val repository: RepoRepository) {

   operator fun invoke(language: String, sort: String) = repository.repositories(language, sort)
}