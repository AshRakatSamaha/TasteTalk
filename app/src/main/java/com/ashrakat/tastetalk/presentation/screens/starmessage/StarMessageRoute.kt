package com.ashrakat.tastetalk.presentation.screens.starmessage

import android.annotation.SuppressLint
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "starMessageScreen"

@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.starMessageRoute(navController: NavController) {
    composable(ROUTE) {
        StarMessageScreen(navController = navController)
    }
}