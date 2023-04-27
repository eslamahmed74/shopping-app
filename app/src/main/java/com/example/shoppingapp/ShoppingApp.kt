package com.example.shoppingapp

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.shoppingapp.navigation.navGraph.ShoppingNavGraph
import com.example.shoppingapp.ui.theme.ShoppingAppTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ShoppingApp() {
    ShoppingAppTheme() {
        val navController = rememberNavController()
        val backStackEntry = navController.currentBackStackEntryAsState()

        Scaffold(bottomBar = { ->
            var isVisible by remember {
                mutableStateOf(false)
            }


            AnimatedVisibility(visible = true,
                enter = slideInVertically(animationSpec = tween(400)) { it },
                exit = slideOutVertically(animationSpec = tween(400)) { it }) {
                BottomNavigationBar(
                    items = listOf(
                        BottomNavigationItem(
                            "Home",
                            Screen.HomeScreen.route,
                            ImageVector.vectorResource(R.drawable.ic_home)
                        ),
                        BottomNavigationItem(
                            "Cart",
                            Screen.CartScreen.route,
                            ImageVector.vectorResource(R.drawable.ic_shop)
                        ),
                        BottomNavigationItem(
                            "Explore",
                            Screen.ExploreScreen.route,
                            ImageVector.vectorResource(R.drawable.ic_home)
                        ),
                        BottomNavigationItem(
                            "Notification",
                            Screen.NotificationScreen.route,
                            ImageVector.vectorResource(R.drawable.ic_home)
                        )
                    ), navController = navController
                ) {
                    navController.navigate(it.route) {
                        launchSingleTop = true
//                        if (backStackEntry.value?.destination?.route != Screen.WelcomeScreen.route ||
//                            backStackEntry.value?.destination?.route != Screen.LoginScreen.route
//                        )
                            !isVisible
                    }
                }
            }
        }) {
            ShoppingNavGraph(navController)
        }

    }
}
