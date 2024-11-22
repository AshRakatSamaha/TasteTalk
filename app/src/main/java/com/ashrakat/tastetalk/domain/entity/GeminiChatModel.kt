package com.ashrakat.tastetalk.domain.entity

import com.google.gson.annotations.SerializedName

data class GeminiChatModel(
    @SerializedName("role")
    val role: String,
    @SerializedName("content")
    val content: String
) {
    companion object {
        const val SENT_BY_USER = "user"
    }
}