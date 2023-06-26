package com.example.composenavigationtalk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val titleStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
val subtitleStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal)
val infoStyle = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Light)

@Composable
internal fun ListScreen() {
    Column {
        Text(text = "List Of Items:")
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            repeat(20) {
                item {
                    OutlinedButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {
                            //TODO: Navigate to Detail Screen
                        }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp)
                                    .background(Color.White)
                            )
                            Spacer(modifier = Modifier.width(15.dp))
                            Column {
                                Text(style = titleStyle, text = "Title ${it + 1}")
                                Text(style = subtitleStyle, text = "Subtitle ${it + 1}")
                                Text(style = infoStyle, text = "Additional Information ${it + 1}")
                            }
                        }
                    }
                }
            }
        }
    }
}