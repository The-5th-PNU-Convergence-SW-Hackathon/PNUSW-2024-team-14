package com.example.jasmin2.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


data class BottomNavItem (
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
)

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home"){
            HomeScreen()
        }
        composable("scroll"){
            ScrollScreen()
        }
        composable("detail"){
            MyDetailScreen()
        }
        composable("My page"){
            MypageScreen()
        }
    }
}



