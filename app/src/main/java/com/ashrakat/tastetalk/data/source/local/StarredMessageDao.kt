package com.ashrakat.tastetalk.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ashrakat.tastetalk.domain.entity.StarredMessageModel

@Dao
interface StarredMessageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: StarredMessageModel)

    @Query("SELECT * FROM starred_messages")
    suspend fun getAllSavedMessages(): List<StarredMessageModel>

    @Delete
    suspend fun delete(message: StarredMessageModel)}