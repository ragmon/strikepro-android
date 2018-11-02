package com.strikepro.catalog.vo.main

import android.arch.persistence.room.Entity

import com.strikepro.catalog.vo.ResourceType

@Entity(
        primaryKeys = ["id"]
)
data class FeedCategory (
        var id: Int,
        var resource_type: ResourceType,
        var resource_name: String
)