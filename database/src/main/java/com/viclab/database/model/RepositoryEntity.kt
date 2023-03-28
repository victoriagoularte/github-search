package com.viclab.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repository")
data class RepositoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val stars: Long,
    val forks: Double,
    val userId: Long
)
