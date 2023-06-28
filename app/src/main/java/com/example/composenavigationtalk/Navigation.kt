package com.example.composenavigationtalk

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.ListScreen.route + "?username={username}",
            arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                    nullable = true
                }
            )) {
            ListScreen(
                navController = navController,
                username = it.arguments?.getString("username")
            )
        }
        composable(
            route = Screen.DetailScreen.route + "/{item_id}",
            arguments = listOf(
                navArgument("item_id") {
                    type = NavType.IntType
                }
            )
        ) {
            DetailScreen(
                navController = navController,
                itemId = it.arguments?.getInt("item_id") ?: 0
            )
        }
    }
}