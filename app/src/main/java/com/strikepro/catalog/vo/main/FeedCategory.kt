package com.strikepro.catalog.vo.main

import androidx.room.Entity

import com.fasterxml.jackson.annotation.JsonProperty

import com.strikepro.catalog.vo.ResourceType

@Entity(
        tableName = "feed_category",
        primaryKeys = ["id"]
)
data class FeedCategory (
        @JsonProperty("id")
        val id: Int,
        @JsonProperty("resource_type")
        val resource_type: ResourceType,
        @JsonProperty("resource_name")
        val resource_name: String
)