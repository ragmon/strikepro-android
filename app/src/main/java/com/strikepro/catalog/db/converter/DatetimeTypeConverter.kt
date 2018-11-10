package com.strikepro.catalog.db.converter

import androidx.room.TypeConverter

import com.strikepro.catalog.common.DATETIME_FORMAT

import java.text.SimpleDateFormat
import java.util.*

@Suppress("unused")
class DatetimeTypeConverter {

    @TypeConverter
    fun toDate(value: String): Date = SimpleDateFormat(DATETIME_FORMAT, Locale.getDefault()).parse(value)

    @TypeConverter
    fun toString(value: Date): String = SimpleDateFormat(DATETIME_FORMAT, Locale.getDefault()).format(value)

}