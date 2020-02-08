package com.app.common.utils;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;

fun getDayOfTheWeek(dateStr: String): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    try {
        val date = dateFormat.parse(dateStr)
        return DateFormat.format("EEEE", date) as String
    } catch (e: Exception) {
        return "-"
    }

}

