package com.viclab.repository.di

import com.viclab.repository.repository.RepoRepository
import com.viclab.repository.usecase.RepositoryListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideRepositoryListUseCase(repository: RepoRepository): RepositoryListUseCase {
        return RepositoryListUseCase(repository)
    }

}