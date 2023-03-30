package com.viclab.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.viclab.database.dao.RemoteKeysDao
import com.viclab.database.dao.RepositoryDao
import com.viclab.database.model.RemoteKeysEntity
import com.viclab.database.model.RepositoryEntity

@Database(
    entities = [RepositoryEntity::class, RemoteKeysEntity::class],
    version = 2
)
abstract class GithubSearchDatabase : RoomDatabase() {
    abstract fun repositoryDao(): RepositoryDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}