package com.ashrakat.tastetalk.data.repository


import com.ashrakat.tastetalk.data.source.remote.chatWithGemini
import com.ashrakat.tastetalk.domain.repository.GeminiChatRepository
import com.google.ai.client.generativeai.type.GenerateContentResponse
import javax.inject.Inject

class GeminiChatRepositoryImpl @Inject constructor(
): GeminiChatRepository {
    override suspend fun sendMessage(message: String): GenerateContentResponse {
        return chatWithGemini(message)
    }

}