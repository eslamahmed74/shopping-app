package com.example.shoppingapp.navigation.navGraph.routes

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.shoppingapp.Screen
import com.example.shoppingapp.WelcomeScreen

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.welcomeScreenRoute(navController: NavController) {
    composable(
        Screen.WelcomeScreen.route)
    {
        WelcomeScreen(onNavigateToLogin = { navController.navigate("loginScreen") })
    }
}