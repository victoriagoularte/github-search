package com.viclab.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repository")
data class RepositoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val stars: Int,
    val forks: Int,
    val login: String,
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String,
    var page: Int = 0,
)
