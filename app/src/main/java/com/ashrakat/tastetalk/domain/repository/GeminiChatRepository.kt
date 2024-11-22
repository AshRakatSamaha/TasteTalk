package com.ashrakat.tastetalk.domain.repository

import com.google.ai.client.generativeai.type.GenerateContentResponse

interface GeminiChatRepository {
    suspend fun sendMessage(message: String): GenerateContentResponse
}