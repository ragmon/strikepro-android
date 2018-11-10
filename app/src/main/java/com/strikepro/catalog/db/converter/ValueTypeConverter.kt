package com.strikepro.catalog.db.converter

import androidx.room.TypeConverter

import com.strikepro.catalog.vo.catalog.ValueType

@Suppress("unused")
class ValueTypeConverter {

    @TypeConverter
    fun toValueType(value: String): ValueType = ValueType.valueOf(value)

    @TypeConverter
    fun toString(value: ValueType): String = value.type

}