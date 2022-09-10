package com.tala.core_utils.utils

import java.text.SimpleDateFormat
import java.util.*

object TimeUtils {
    fun formatDate(date: String?, originFormat: String, toFormat: String): String? {
        return try {
            val parsedDate = SimpleDateFormat(originFormat, Locale.getDefault()).parse(date)
            SimpleDateFormat(toFormat, Locale.getDefault()).format(parsedDate)
        } catch (e: Exception) {
            date
        }
    }

    fun parseDatFromLong(dateInLong: Long, format: String = "E, MMM yyyy HH:mm a"): String {
        return try {
            val date = Date(dateInLong)
            return SimpleDateFormat(format, Locale.getDefault()).format(date)
        } catch (e: Exception) {
            dateInLong.toString()
        }
    }
}