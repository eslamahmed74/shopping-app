package com.example.shoppingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavigationItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    BottomNavigation(modifier = modifier, backgroundColor = Color.White, elevation = 5.dp) {
        items.forEach { item ->
            val isSelected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = isSelected,
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.Gray,
                onClick = { onItemClick(item) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(badge = {
                                Box(
                                    modifier
                                        .size(15.dp)
                                        .clip(CircleShape)
                                        .background(Color.Magenta),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = item.badgeCount.toString(),
                                        color = Color.White,
                                        fontSize = 10.sp
                                    )
                                }

                            }) {
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    painter = rememberVectorPainter(
                                        item.icon
                                    ), contentDescription = item.name
                                )
                            }
                        } else {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                painter = rememberVectorPainter(
                                    item.icon
                                ), contentDescription = item.name
                            )
                        }

                        if (isSelected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }

                    }
                })
        }
    }
}