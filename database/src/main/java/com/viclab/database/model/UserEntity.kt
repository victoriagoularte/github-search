package com.viclab.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val login: String,
    val avatarUrl: String,
)
