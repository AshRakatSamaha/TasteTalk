package com.ashrakat.tastetalk.presentation.mvvm


import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashrakat.tastetalk.data.repository.StarredMessageRepository
import com.ashrakat.tastetalk.domain.entity.GeminiChatModel
import com.ashrakat.tastetalk.domain.entity.StarredMessageModel
import com.ashrakat.tastetalk.domain.repository.GeminiChatRepository
import com.google.ai.client.generativeai.type.GenerateContentResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeminiChatViewModel @Inject constructor(
    private val repository: GeminiChatRepository,

) : ViewModel() {

    private val _chatHistory = MutableStateFlow<List<GeminiChatModel>>(emptyList())
    val chatHistory: StateFlow<List<GeminiChatModel>> = _chatHistory

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading






    fun sendMessage(message: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _chatHistory.value =
                _chatHistory.value + GeminiChatModel(GeminiChatModel.SENT_BY_USER, message)

            try {
                val response: GenerateContentResponse = repository.sendMessage(message)
                val botReply = response.text ?: "No response from bot."
                _chatHistory.value = _chatHistory.value + GeminiChatModel("bot", botReply)
            } catch (e: Exception) {
                _chatHistory.value =
                    _chatHistory.value + GeminiChatModel("bot", "Error: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun copyMessage(context: Context, message: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Copied Message", message)
        clipboard.setPrimaryClip(clip)
    }


}