package com.viclab.repository.di

import com.viclab.repository.datasource.remote.RepositoryRemoteDataSource
import com.viclab.repository.datasource.remote.RepositoryRemoteDataSourceImpl
import com.viclab.repository.repository.RepoRepository
import com.viclab.repository.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class DataModule {

    @Binds
    abstract fun bindRemoteRepositoryDataSource(
        remoteMovieDetailDataSourceImpl: RepositoryRemoteDataSourceImpl
    ): RepositoryRemoteDataSource

    @Binds
    abstract fun bindRepoRepository(
        repoRepositoryImpl: RepositoryImpl
    ): RepoRepository
}