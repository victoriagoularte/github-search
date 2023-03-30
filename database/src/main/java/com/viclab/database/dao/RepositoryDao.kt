package com.viclab.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.viclab.database.model.RepositoryEntity

@Dao
interface RepositoryDao {

    @Query(
        value = """
            SELECT * FROM repository
            ORDER BY stars DESC
    """
    )
    fun getRepositoryList(): PagingSource<Int, RepositoryEntity>

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repositoryList: List<RepositoryEntity>)

    @Query("DELETE FROM repository")
    suspend fun clearRepositories()
}