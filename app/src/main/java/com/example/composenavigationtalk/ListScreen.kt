package com.example.composenavigationtalk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composenavigationtalk.views.NavigationBarView
import com.example.composenavigationtalk.views.urlEncode

val titleStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
val subtitleStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal)
val infoStyle = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Light)


@Composable
internal fun ListScreen(
    navController: NavController,
    username: String?,
) {
    val repositoryLayer = RepositoryLayer()
    Column {
        NavigationBarView(currentScreen = Screen.ListScreen, canNavigateBack = false)
        if (!username.isNullOrBlank()) {
            Text(text = "Welcome $username!")
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            repositoryLayer.getListItems().forEach {
                item {
                    OutlinedButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {
                            //TODO: Navigate to Detail Screen
                            navController.navigate(Screen.DetailScreen.route + "/${it.id}")
                        }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .width(50.dp)
                                        .height(50.dp)
                                        .background(Color.White)
                                )
                                Icon(
                                    repositoryLayer.getIcon(it.icon),
                                    contentDescription = "Icon",
                                    modifier = Modifier.scale(2f),
                                    tint = Color.Black
                                )
                            }
                            Spacer(modifier = Modifier.width(15.dp))
                            Column {
                                Text(style = titleStyle, text = it.title)
                                it.subtitle?.let { subtitle ->
                                    Text(style = subtitleStyle, text = subtitle)
                                }
                                it.add_info?.let { add_info ->
                                    Text(style = infoStyle, text = add_info)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}