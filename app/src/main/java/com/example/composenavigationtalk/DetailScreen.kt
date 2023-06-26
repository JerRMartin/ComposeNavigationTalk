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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.composenavigationtalk.views.NavigationBarView

@Composable
internal fun DetailScreen() {
    Column {
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
                icons.random(), // TODO: Get icon from previous screen
                contentDescription = "Icon",
                modifier = Modifier.scale(4f),
                tint = Color.Black
            )
        }

        LazyColumn(modifier = Modifier.padding(horizontal = 50.dp)) {
            item {
                Text(style = titleStyle, text = "Title" ) // TODO: Get title from previous screen
            }
            item {
                Text(style = subtitleStyle, text = "Subtitle") // TODO: Get subtitle from previous screen
            }
            item {
                Text(style = infoStyle, text = "Additional Information") // TODO: Get additional info from previous screen
            }
        }
    }
}