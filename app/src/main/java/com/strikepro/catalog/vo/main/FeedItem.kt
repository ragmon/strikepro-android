package com.strikepro.catalog.vo.main

import androidx.room.Entity

import com.strikepro.catalog.vo.BaseFeedItem

@Entity(
        tableName = "feed_item",
        primaryKeys = ["id"]
)
data class FeedItem (
        var id: Int,
        var resource: BaseFeedItem,
        var created_at: String,
        var updated_at: String
)