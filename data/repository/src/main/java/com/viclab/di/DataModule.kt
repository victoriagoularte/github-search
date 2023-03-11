package com.viclab.di

import com.viclab.datasource.RepositoryRemoteDataSource
import com.viclab.datasource.RepositoryRemoteDataSourceImpl
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

}