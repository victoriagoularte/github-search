package com.viclab.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class RepositoryWithUser(
    @Embedded val repository: RepositoryEntity,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "id"
    )
    val user: UserEntity
)
