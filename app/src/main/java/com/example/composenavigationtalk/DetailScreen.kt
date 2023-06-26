package com.example.composenavigationtalk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
internal fun DetailScreen() {
    Column {
        Box(modifier = Modifier.padding(25.dp)) {
            Box(
                modifier = Modifier.height(200.dp).fillMaxWidth().background(Color.White)
            )
        }
        LazyColumn(modifier = Modifier.padding(horizontal = 50.dp)) {
            item {
                Text(style = titleStyle, text = "Title")
            }
            item {
                Text(style = subtitleStyle, text = "Subtitle")
            }
            item {
                Text(style = infoStyle, text = "Additional Information")
            }
        }
    }
}