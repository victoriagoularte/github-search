package com.viclab.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.viclab.database.model.RepositoryEntity

@Dao
interface RepositoryDao {

    @Transaction
    @Query(
        value = """
            SELECT * FROM repository
            ORDER BY stars DESC
    """
    )
    fun getRepositoryList(): List<RepositoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(account: RepositoryEntity)

    @Delete
    suspend fun delete(account: RepositoryEntity)

    @Update
    suspend fun updateRepositories(entities: List<RepositoryEntity>)
}