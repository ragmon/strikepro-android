package com.strikepro.catalog.vo.main

import android.arch.persistence.room.Entity

import com.strikepro.catalog.vo.BaseFeedItem

@Entity(
        primaryKeys = ["id"]
)
data class FeedItem (
        var id: Int,
        var resource: BaseFeedItem,
        var created_at: String,
        var updated_at: String
)