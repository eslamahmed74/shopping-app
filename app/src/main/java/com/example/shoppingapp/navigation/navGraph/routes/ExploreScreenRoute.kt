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
import com.example.ExploreScreen
import com.example.shoppingapp.Screen
import androidx.navigation.compose.composable

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.exploreScreenRoute(navController: NavController) {
    composable(
        Screen.ExploreScreen.route,
       )
    {
        ExploreScreen()
    }
}