package com.ml34.aroundegypt.data.db.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ml34.aroundegypt.data.model.ExperienceModel

@Dao
interface RecentDao {

    @Query("SELECT * FROM experiences")
    suspend fun getAllRecent(): List<ExperienceModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllRecent(items: List<ExperienceModel>)

    @Query("DELETE FROM experiences")
    suspend fun deleteAllRecent()
}