package com.example.composenavigationtalk.views

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NavigationBarView() {
    val backStackPopulated: Boolean by remember { mutableStateOf(true) }

    TopAppBar {
        if (backStackPopulated) {
            IconButton(
                onClick = {
                    // TODO: Navigate Back
                }
            ) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = "Back Button"
                )
            }
        }
    }
}

@Composable
@Preview
fun NavigationBarViewPreview() {
    NavigationBarView()
}