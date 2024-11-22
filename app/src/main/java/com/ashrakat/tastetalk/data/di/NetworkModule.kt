package com.ashrakat.tastetalk.data.di

import android.content.Context
import com.ashrakat.tastetalk.base.NetworkHandler
import com.ashrakat.tastetalk.data.utilites.NetworkUtility
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideNetworkUtility(@ApplicationContext context: Context): NetworkUtility {
        return NetworkUtility(context)
    }

    @Provides
    @Singleton
    fun provideNetworkHandler(networkUtility: NetworkUtility): NetworkHandler {
        return NetworkHandler(networkUtility)
    }
}