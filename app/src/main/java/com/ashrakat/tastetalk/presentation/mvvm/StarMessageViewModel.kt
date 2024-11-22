package com.ashrakat.tastetalk.presentation.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashrakat.tastetalk.data.repository.StarredMessageRepository
import com.ashrakat.tastetalk.domain.entity.StarredMessageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarMessageViewModel@Inject constructor(
    private val starredMessageRepository: StarredMessageRepository
):ViewModel() {
    private val _starredMessages = MutableStateFlow<List<StarredMessageModel>>(emptyList())
    val starredMessages: StateFlow<List<StarredMessageModel>> = _starredMessages

    init {
        getStarredMessages()
    }

    fun starredMessage(message: String) {
        viewModelScope.launch {
            starredMessageRepository.starMessage(StarredMessageModel(content = message))
            Log.d("GeminiChatViewModel", "Starred message: $message")
        }
    }

    fun deleteStarredMessage(message: StarredMessageModel) {
        viewModelScope.launch {
            starredMessageRepository.deleteStarredMessage(message)
            _starredMessages.value = starredMessageRepository.getStarredMessages()
        }
    }


    private fun getStarredMessages() {
        viewModelScope.launch {
            _starredMessages.value = starredMessageRepository.getStarredMessages()

        }
    }
}