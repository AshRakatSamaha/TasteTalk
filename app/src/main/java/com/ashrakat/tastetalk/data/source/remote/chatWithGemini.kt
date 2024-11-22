package com.ashrakat.tastetalk.data.source.remote

import com.ashrakat.tastetalk.domain.entity.GeminiChatModel
import com.ashrakat.tastetalk.utilites.Constants
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.GenerateContentResponse
import com.google.ai.client.generativeai.type.content


object Gemini {
    val chatHistory = mutableListOf<GeminiChatModel>()
}

suspend fun chatWithGemini(
    message: String,
    modelName: String = "gemini-1.5-flash"
): GenerateContentResponse {
    val generativeModel = GenerativeModel(
        // The Gemini 1.5 models are versatile and work with multi-turn conversations (like chat)
        modelName = modelName,
        // Access your API key as a Build Configuration variable (see "Set up your API key" above)
        apiKey = Constants.GEMINI_API_KEY
    )

    // Add a system message to guide the conversation
    val initialInstructions = content(role = "model") {
        text(
            "You are a specialized assistant in food and culinary topics." +
                    " Feel free to respond naturally to general greetings, pleasantries," +
                    " casual conversation, or expressions of gratitude," +
                    " such as 'Thank you', 'Hi', 'How are you?' or other similar sentiments." +
                    " For all other questions related to food, cooking, recipes, and nutrition," +
                    " provide detailed and helpful responses. You may include recipe steps, nutritional advice," +
                    " or images of dishes if requested. If the user asks about topics unrelated" +
                    " to food or culinary subjects, don't answer their question and " +
                    " kindly remind them with: 'Please ask questions related to food, recipes, or nutrition only.'"
        )
    }

    val chat = generativeModel.startChat(
        history = listOf(initialInstructions) + Gemini.chatHistory.map {
            content(role = it.role) {
                text(
                    it.content
                )
            }
        })
    return chat.sendMessage(message)
}
