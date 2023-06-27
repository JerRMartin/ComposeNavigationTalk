package com.example.composenavigationtalk

sealed class Screen(
    val title: String,
    val route: String
) {
    object LoginScreen : Screen("", "login_screen")
    object ListScreen : Screen("List Screen", "list_screen")
    object DetailScreen : Screen("Detail Screen", "detail_screen")
}
