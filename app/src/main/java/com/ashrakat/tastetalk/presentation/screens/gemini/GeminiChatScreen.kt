package com.ashrakat.tastetalk.presentation.screens.gemini

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ashrakat.tastetalk.R
import com.ashrakat.tastetalk.domain.entity.GeminiChatModel
import com.ashrakat.tastetalk.presentation.composable.BackIcon
import com.ashrakat.tastetalk.presentation.composable.CardSendMessage
import com.ashrakat.tastetalk.presentation.composable.ChatMessage
import com.ashrakat.tastetalk.presentation.composable.LoadingIndicator
import com.ashrakat.tastetalk.presentation.composable.TitleText
import com.ashrakat.tastetalk.presentation.mvvm.GeminiChatViewModel
import com.ashrakat.tastetalk.presentation.mvvm.StarMessageViewModel
import com.ashrakat.tastetalk.ui.theme.Background

@Composable
fun GeminiChatScreen(
    navController: NavController,
    chatViewModel: GeminiChatViewModel = hiltViewModel(),
    starViewModel: StarMessageViewModel = hiltViewModel()
) {
    val chatHistory by chatViewModel.chatHistory.collectAsState()
    val isLoading by chatViewModel.isLoading.collectAsState()

    GeminiChatContent(navController = navController,
        chatHistory = chatHistory,
        isLoading = isLoading,
        onCopyMessage = { message ->
            chatViewModel.copyMessage(navController.context, message)
            Toast.makeText(navController.context, "Copied Message", Toast.LENGTH_SHORT).show()
        },
        onStarMessage = { message ->
            starViewModel.starredMessage(message)
            Log.d("StarredMessage", message)
            Toast.makeText(navController.context, "Starred Message", Toast.LENGTH_SHORT).show()
        },
        onSendMessage = { message ->
            chatViewModel.sendMessage(message)
        })
}


@Composable
fun GeminiChatContent(
    navController: NavController,
    chatHistory: List<GeminiChatModel>,
    isLoading: Boolean,
    onCopyMessage: (String) -> Unit,
    onStarMessage: (String) -> Unit,
    onSendMessage: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        ChatHeader(navController = navController)

        if (chatHistory.isEmpty()) {
            EmptyState(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally)
            )
        } else {
            ChatList(
                chatHistory = chatHistory,
                onCopyMessage = onCopyMessage,
                onStarMessage = onStarMessage,
                modifier = Modifier.weight(1f)
            )
        }

        if (isLoading) {
            LoadingIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        InputField(onSendMessage = onSendMessage)
    }
}

@Composable
fun ChatHeader(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 16.dp, top = 32.dp, bottom = 8.dp)
    ) {
        BackIcon(onClick = { navController.popBackStack() })
        TitleText(text = stringResource(id = R.string.app_name))
    }
}

@Composable
fun EmptyState(
    modifier: Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_gemini),
        contentDescription = null,
        modifier = modifier.padding(32.dp)
    )
}

@Composable
fun ChatList(
    chatHistory: List<GeminiChatModel>,
    onCopyMessage: (String) -> Unit,
    onStarMessage: (String) -> Unit,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(16.dp)
            .background(Background), reverseLayout = true
    ) {
        items(chatHistory.reversed()) { chat ->
            ChatMessage(message = chat.content,
                isUser = chat.role == GeminiChatModel.SENT_BY_USER,
                onClickToCopyMessage = { onCopyMessage(chat.content) },
                onClickToStarMessage = { onStarMessage(chat.content) })
        }
    }
}


@Composable
fun InputField(onSendMessage: (String) -> Unit) {
    CardSendMessage(onSendMessage = onSendMessage)
}
