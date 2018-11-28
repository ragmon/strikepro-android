package com.strikepro.catalog.db.converter

import androidx.room.TypeConverter
import com.strikepro.catalog.vo.ResourceType

@Suppress("unused")
class ResourceTypeConverter {

    @TypeConverter
    fun toResourceType(value: String): ResourceType = ResourceType.valueOf(value.toUpperCase())

    @TypeConverter
    fun toString(value: ResourceType): String = value.type

}