package com.example.shoppingapp.navigation.navGraph.routes

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.CartScreen
import com.example.shoppingapp.Screen
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