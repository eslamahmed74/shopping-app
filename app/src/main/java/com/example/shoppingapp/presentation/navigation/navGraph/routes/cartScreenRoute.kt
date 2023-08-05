package com.example.shoppingapp.presentation.navigation.navGraph.routes

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.shoppingapp.presentation.CartScreen
import com.example.shoppingapp.presentation.Screen
import androidx.navigation.compose.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.cartScreenRoute(navController: NavController) {
    composable(
        Screen.CartScreen.route,
        )
    {
        CartScreen()
    }
}