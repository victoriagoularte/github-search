package com.viclab.database.di

import com.viclab.database.GithubSearchDatabase
import com.viclab.database.dao.RepositoryDao
import com.viclab.database.dao.UserDao
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
    fun providesUserDao(
        database: GithubSearchDatabase,
    ): UserDao = database.userDao()
}