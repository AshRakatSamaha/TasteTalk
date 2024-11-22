package com.ashrakat.tastetalk.presentation.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "homeScreen"
fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable(ROUTE,) {
        HomeScreen(navController)
    }
}