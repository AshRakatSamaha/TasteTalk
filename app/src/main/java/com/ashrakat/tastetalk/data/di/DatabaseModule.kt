package com.ashrakat.tastetalk.data.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.ashrakat.tastetalk.data.source.local.TasteTalkDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): TasteTalkDataBase {
        return Room.databaseBuilder(
            application,
            TasteTalkDataBase::class.java,
            "taste_talk_database"
        ).build()
    }

    @Provides
    fun provideSavedMessageDao(db: TasteTalkDataBase) = db.savedMessageDao()
}