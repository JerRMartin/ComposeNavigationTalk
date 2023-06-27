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

val icons =
    listOf(  // not making this private so we can read it in Detail Screen, again BAD TO DO!!
        Icons.Rounded.Star,
        Icons.Rounded.Face,
        Icons.Rounded.Person,
        Icons.Default.ThumbUp
    )

private val listItems = listOf(
    ListItem(
        0,
        "Star Item",
        "Important Item",
        "12/25/2023"
    ),
    ListItem(
        1,
        "Face Item",
        "Its a Face Item",
        "09/09/2009"
    ),
    ListItem(
        2,
        "Person Item",
        "Who let this guy in?",
        "02/28/2018"
    ),
    ListItem(
        3, "Thumbs Up Item",
        "Honestly, Great Job.",
        "01/01/2021"
    ),
    ListItem(
        1,
        "A Different Face Item",
        "Its a Different Face Item",
        "09/10/2009"
    ),
)


@Composable
internal fun ListScreen(
    navController: NavController,
    username: String?
) {
    Column {
        NavigationBarView(currentScreen = Screen.ListScreen, canNavigateBack = false)
        if (!username.isNullOrBlank()) {
            Text(text = "Welcome $username!")
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            listItems.forEach {
                item {
                    OutlinedButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {
                            //TODO: Navigate to Detail Screen
                            navController.navigate(
                                Screen.DetailScreen.route +
                                        "/${it.icon}" +
                                        "/${it.title.urlEncode()}" +
                                        "?subtitle=${it.subtitle?.urlEncode()}" +
                                        "?add_info=${it.add_info?.urlEncode()}"
                            )
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
                                    icons[it.icon],
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