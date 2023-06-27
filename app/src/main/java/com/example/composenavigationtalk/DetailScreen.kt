package com.example.composenavigationtalk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composenavigationtalk.views.NavigationBarView
import com.example.composenavigationtalk.views.urlDecode

@Composable
internal fun DetailScreen(
    navController: NavController,
    icon: Int,
    title: String,
    subtitle: String?,
    addInfo: String?,
) {
    Column {
        NavigationBarView(currentScreen = Screen.DetailScreen, canNavigateBack = true) {
            navController.navigate(Screen.ListScreen.route)
        }
        Box(
            modifier = Modifier.padding(25.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            )
            Icon(
                icons[icon], // This is not the correct way to do something like this, just for simplicity here
                contentDescription = "Icon",
                modifier = Modifier.scale(4f),
                tint = Color.Black
            )
        }

        LazyColumn(modifier = Modifier.padding(horizontal = 50.dp)) {
            item {
                Text(style = titleStyle, text = title.urlDecode())
            }
            item {
                if (subtitle != null) {
                    Text(style = subtitleStyle, text = subtitle.urlDecode())
                }
            }
            item {
                if (addInfo != null) {
                    Text(style = infoStyle, text = addInfo.urlDecode())
                }
            }
        }
    }
}