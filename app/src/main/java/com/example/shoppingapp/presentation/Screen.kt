package com.example.shoppingapp.presentation

sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("welcomeScreen")
    object LoginScreen : Screen("loginScreen")
    object HomeScreen : Screen("homeScreen")
    object ExploreScreen : Screen("exploreScreen")
    object NotificationScreen : Screen("notificationScreen")
    object CartScreen : Screen("cartScreen")
}