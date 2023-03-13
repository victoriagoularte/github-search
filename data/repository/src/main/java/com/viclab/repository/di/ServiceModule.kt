package com.viclab.repository.di

import com.viclab.repository.remote.RepositoryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object ServiceModule {

    @Provides
    fun provideRepositoryService(retrofit: Retrofit): RepositoryService =
        retrofit.create(RepositoryService::class.java)
}