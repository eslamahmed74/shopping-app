package com.example.shoppingapp.presentation.navigation.navGraph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.shoppingapp.presentation.Screen
import com.example.shoppingapp.presentation.navigation.navGraph.routes.cartScreenRoute
import com.example.shoppingapp.presentation.navigation.navGraph.routes.exploreScreenRoute
import com.example.shoppingapp.presentation.navigation.navGraph.routes.homeScreenRoute
import com.example.shoppingapp.presentation.navigation.navGraph.routes.loginScreenRoute
import com.example.shoppingapp.presentation.navigation.navGraph.routes.notificationScreenRoute
import com.example.shoppingapp.presentation.navigation.navGraph.routes.welcomeScreenRoute

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ShoppingNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route) {
        welcomeScreenRoute(navController)
        loginScreenRoute(navController)
        homeScreenRoute(navController)
        cartScreenRoute(navController)
        notificationScreenRoute(navController)
        exploreScreenRoute(navController)
    }
}