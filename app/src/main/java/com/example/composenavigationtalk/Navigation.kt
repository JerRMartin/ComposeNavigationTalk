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
            route = Screen.DetailScreen.route +
                    "/{icon}" +
                    "/{title}" +
                    "?subtitle={subtitle}" +
                    "?add_info={add_info}",
            arguments = listOf(
                navArgument("icon") {
                    type = NavType.IntType
                },
                navArgument("title") {
                    type = NavType.StringType
                },
                navArgument("subtitle") {
                    type = NavType.StringType
                    nullable = true
                },
                navArgument("add_info") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            DetailScreen(
                navController = navController,
                icon = it.arguments?.getInt("icon") ?: 0,
                title = it.arguments?.getString("title") ?: "fallback_title",
                subtitle = it.arguments?.getString("subtitle"),
                addInfo = it.arguments?.getString("add_info"),
            )
        }
    }
}