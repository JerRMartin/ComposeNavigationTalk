package com.example.composenavigationtalk.views

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composenavigationtalk.Screen

@Composable
fun NavigationBarView(
    currentScreen: Screen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
) {
    TopAppBar(
        title = {
            Text(text = currentScreen.title)
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(
                    onClick = navigateUp
                ) {
                    Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = "Back Button"
                    )
                }
            }
        }
    )
}

@Composable
@Preview
fun NavigationBarViewPreview() {
    NavigationBarView(currentScreen= Screen.DetailScreen, canNavigateBack = true) { }
}

@Composable
@Preview
fun NavigationBarViewPreviewNoNav() {
    NavigationBarView(currentScreen= Screen.ListScreen, canNavigateBack = false) { }
}