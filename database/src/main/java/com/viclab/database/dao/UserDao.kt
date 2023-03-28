package com.viclab.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.viclab.database.model.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUserById(id: Long): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(account: UserEntity)

    @Delete
    suspend fun delete(account: UserEntity)
}