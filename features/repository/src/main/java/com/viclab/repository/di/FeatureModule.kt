package com.viclab.repository.di

import com.viclab.repository.search.RepositoriesPagingSource
import com.viclab.repository.usecase.RepositoryListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object FeatureModule {

    @Provides
    fun provideRepositoriesPagingSource(
        language: String,
        sort: String,
        useCase: RepositoryListUseCase
    ) : RepositoriesPagingSource {
        return RepositoriesPagingSource(language, sort, useCase)
    }
}