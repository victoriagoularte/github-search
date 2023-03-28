package com.viclab.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
@Entity(
    tableName = "repository_user",
    primaryKeys = ["repository_id", "user_id"],
    foreignKeys = [
        ForeignKey(
            entity = RepositoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["repository_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        ),
    ],
    indices = [
        Index(value = ["repository_id"]),
        Index(value = ["user_id"]),
    ],
)

data class RepositoryUserCrossRef(
    @ColumnInfo(name = "news_resource_id")
    val repositoryId: Long,
    @ColumnInfo(name = "topic_id")
    val userId: Long,
)