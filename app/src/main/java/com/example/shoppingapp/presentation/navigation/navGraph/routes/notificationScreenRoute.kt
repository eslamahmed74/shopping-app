package com.example.shoppingapp.presentation.navigation.navGraph.routes

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.shoppingapp.presentation.NotificationScreen
import com.example.shoppingapp.presentation.Screen
import androidx.navigation.compose.composable

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.notificationScreenRoute(navController: NavController) {
    composable(
        Screen.NotificationScreen.route)
    {
        NotificationScreen()
    }
}