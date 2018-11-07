package com.strikepro.catalog.vo.main

import androidx.room.Entity

import com.strikepro.catalog.vo.ResourceType

@Entity(
        tableName = "feed_category",
        primaryKeys = ["id"]
)
data class FeedCategory (
        var id: Int,
        var resource_type: ResourceType,
        var resource_name: String
)