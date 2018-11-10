package com.strikepro.catalog.vo.main

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

import com.fasterxml.jackson.annotation.JsonProperty
import com.strikepro.catalog.db.converter.ResourceTypeConverter

import com.strikepro.catalog.vo.ResourceType

import java.util.*

@Entity(
        tableName = "feed_category"
)
@TypeConverters(value = [ResourceTypeConverter::class])
data class FeedCategory (
        @NonNull
        @PrimaryKey
        @ColumnInfo(name = "id")
        @JsonProperty("id")
        var id: Int,

        @ColumnInfo(name = "resource_type")
        @JsonProperty("resource_type")
        var resource_type: ResourceType,

        @ColumnInfo(name = "resource_name")
        @JsonProperty("resource_name")
        var resource_name: String,

        @ColumnInfo(name = "created_at")
        @JsonProperty("created_at")
        var created_at: Date,

        @ColumnInfo(name = "updated_at")
        @JsonProperty("updated_at")
        var updated_at: Date
)