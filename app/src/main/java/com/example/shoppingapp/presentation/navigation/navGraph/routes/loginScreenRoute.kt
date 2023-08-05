package com.example.shoppingapp.presentation.navigation.navGraph.routes

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.shoppingapp.presentation.Screen
import com.example.shoppingapp.presentation.loginScreen.LoginState
import androidx.navigation.compose.composable

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.loginScreenRoute(navController: NavController) {
    composable(
        Screen.LoginScreen.route,
        )
    {
        LoginState({ navController.navigate("homeScreen") })
    }
}