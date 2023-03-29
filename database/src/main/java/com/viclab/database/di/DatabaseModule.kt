package com.viclab.database.di

import android.content.Context
import androidx.room.Room
import com.viclab.database.GithubSearchDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesGithubSearchDatabase(
        @ApplicationContext context: Context,
    ): GithubSearchDatabase = Room.databaseBuilder(
        context,
        GithubSearchDatabase::class.java,
        "githubsearch-database"
    ).fallbackToDestructiveMigration().build()
}