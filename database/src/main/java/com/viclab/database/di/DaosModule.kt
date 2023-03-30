package com.viclab.database.di

import com.viclab.database.GithubSearchDatabase
import com.viclab.database.dao.RemoteKeysDao
import com.viclab.database.dao.RepositoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun providesRepositoryDao(
        database: GithubSearchDatabase,
    ): RepositoryDao = database.repositoryDao()

    @Provides
    fun providesRemoteKeysDao(
        database: GithubSearchDatabase,
    ): RemoteKeysDao = database.remoteKeysDao()
}