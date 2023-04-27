package com.example.shoppingapp.navigation.navGraph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.shoppingapp.Screen
import com.example.shoppingapp.navigation.navGraph.routes.cartScreenRoute
import com.example.shoppingapp.navigation.navGraph.routes.exploreScreenRoute
import com.example.shoppingapp.navigation.navGraph.routes.homeScreenRoute
import com.example.shoppingapp.navigation.navGraph.routes.loginScreenRoute
import com.example.shoppingapp.navigation.navGraph.routes.notificationScreenRoute
import com.example.shoppingapp.navigation.navGraph.routes.welcomeScreenRoute
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

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