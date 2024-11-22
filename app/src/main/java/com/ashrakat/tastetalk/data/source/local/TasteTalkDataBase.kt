package com.ashrakat.tastetalk.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ashrakat.tastetalk.domain.entity.StarredMessageModel

@Database(entities = [StarredMessageModel::class], version = 1)
abstract class TasteTalkDataBase : RoomDatabase(){
    abstract fun savedMessageDao(): StarredMessageDao
}