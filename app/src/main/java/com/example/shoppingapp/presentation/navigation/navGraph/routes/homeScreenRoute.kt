package com.example.shoppingapp.presentation.navigation.navGraph.routes

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.shoppingapp.presentation.Screen
import androidx.navigation.compose.composable
import com.example.shoppingapp.presentation.homeScreen.HomeScreenState

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.homeScreenRoute(navController: NavController) {
    composable(
        Screen.HomeScreen.route,
        )
    {
        HomeScreenState()
    }
}