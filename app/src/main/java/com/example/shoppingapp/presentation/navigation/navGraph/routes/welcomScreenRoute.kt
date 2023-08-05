package com.example.shoppingapp.presentation.navigation.navGraph.routes

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.shoppingapp.presentation.Screen
import com.example.shoppingapp.presentation.WelcomeScreen

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.welcomeScreenRoute(navController: NavController) {
    composable(
        Screen.WelcomeScreen.route)
    {
        WelcomeScreen(onNavigateToLogin = { navController.navigate("loginScreen") })
    }
}