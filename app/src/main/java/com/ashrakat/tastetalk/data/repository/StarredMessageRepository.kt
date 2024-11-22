package com.ashrakat.tastetalk.data.repository

import com.ashrakat.tastetalk.data.source.local.TasteTalkDataBase
import com.ashrakat.tastetalk.domain.entity.StarredMessageModel
import javax.inject.Inject


class StarredMessageRepository @Inject constructor(
    private val db: TasteTalkDataBase
) {
    suspend fun starMessage(message: StarredMessageModel) {
        db.savedMessageDao().insertMessage(message)
    }

    suspend fun getStarredMessages(): List<StarredMessageModel> {
        return db.savedMessageDao().getAllSavedMessages()
    }
    suspend fun deleteStarredMessage(message: StarredMessageModel) {
        db.savedMessageDao().delete(message)
    }

}