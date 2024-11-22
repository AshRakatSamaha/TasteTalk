package com.ashrakat.tastetalk.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "starred_messages")
data class StarredMessageModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String
)