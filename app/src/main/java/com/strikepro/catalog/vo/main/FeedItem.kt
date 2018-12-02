package com.strikepro.catalog.vo.main

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

import com.strikepro.catalog.vo.BaseFeedItem
import com.strikepro.catalog.vo.ResourceType

import java.util.*

@Entity(
        tableName = "feed_item"
)
data class FeedItem (
        @NonNull
        @PrimaryKey
        @ColumnInfo(name = "id")
        @JsonProperty("id")
        var id: Int,

        @ColumnInfo(name = "resource_type")
        @JsonProperty("resource_type")
        var resourceType: ResourceType,

        @ColumnInfo(name = "resource_id")
        @JsonProperty("resource_id")
        var resourceId: Int,

        @ColumnInfo(name = "created_at")
        @JsonProperty("created_at")
        var createdAt: Date,

        @ColumnInfo(name = "updated_at")
        @JsonProperty("updated_at")
        var updatedAt: Date
) {
        @Ignore
        @JsonIgnore
        lateinit var resource: BaseFeedItem
}