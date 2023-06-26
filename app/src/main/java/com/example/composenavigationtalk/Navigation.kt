package com.example.composenavigationtalk

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val navHost = NavHost(navController = navController, startDestination =  )
}