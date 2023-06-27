package com.example.composenavigationtalk.views

import java.net.URLDecoder
import java.net.URLEncoder

fun String.urlEncode(): String {
    return URLEncoder.encode(this, "UTF-8")
}


fun String.urlDecode(): String {
    return URLDecoder.decode(this, "UTF-8")
}