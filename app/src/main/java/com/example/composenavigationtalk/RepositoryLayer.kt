package com.example.composenavigationtalk

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.graphics.vector.ImageVector

class RepositoryLayer {
    data class ListItem(
        val id: Int,
        val icon: Int,
        val title: String,
        val subtitle: String?,
        val add_info: String?
    )

    private val icons =
        listOf(  // not making this private so we can read it in Detail Screen, again BAD TO DO!!
            Icons.Rounded.Star,
            Icons.Rounded.Face,
            Icons.Rounded.Person,
            Icons.Default.ThumbUp
        )

    private val listItems = listOf(
        ListItem(
            0,
            0,
            "Star Item",
            "Important Item",
            "12/25/2023"
        ),
        ListItem(
            1,
            1,
            "Face Item",
            "Its a Face Item",
            "09/09/2009"
        ),
        ListItem(
            2,
            2,
            "Person Item",
            "Who let this guy in?",
            "02/28/2018"
        ),
        ListItem(
            3,
            3, "Thumbs Up Item",
            "Honestly, Great Job.",
            "01/01/2021"
        ),
        ListItem(
            4,
            1,
            "A Different Face Item",
            "Its a Different Face Item",
            "09/10/2009"
        ),
    )

    fun getIcon(index: Int) : ImageVector {
        return icons[index]
    }

    fun getListItem(index: Int) : ListItem {
        return listItems[index]
    }

    fun getListItems() : List<ListItem> {
        return listItems
    }
}