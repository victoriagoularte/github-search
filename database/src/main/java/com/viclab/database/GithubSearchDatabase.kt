package com.viclab.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.viclab.database.dao.RepositoryDao
import com.viclab.database.dao.UserDao
import com.viclab.database.model.RepositoryEntity
import com.viclab.database.model.UserEntity

@Database(entities = [UserEntity::class, RepositoryEntity::class], version = 1)
abstract class GithubSearchDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun repositoryDao(): RepositoryDao
}