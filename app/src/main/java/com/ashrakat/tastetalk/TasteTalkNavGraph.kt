package com.ashrakat.tastetalk

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.ashrakat.tastetalk.presentation.screens.gemini.geminiChatRoute
import com.ashrakat.tastetalk.presentation.screens.home.homeRoute
import com.ashrakat.tastetalk.presentation.screens.starmessage.starMessageRoute

@Composable
fun TasteTalkNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "homeScreen") {
        homeRoute(navController = navController)
        geminiChatRoute(navController = navController)
        starMessageRoute( navController = navController)

    }
}