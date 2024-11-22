package com.ashrakat.tastetalk.presentation.screens.gemini

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "geminiChatScreen"
fun NavGraphBuilder.geminiChatRoute(navController: NavController) {
    composable(ROUTE) {
        GeminiChatScreen(navController)
    }
}