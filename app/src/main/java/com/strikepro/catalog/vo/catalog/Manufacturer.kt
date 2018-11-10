package com.strikepro.catalog.vo.catalog

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import com.fasterxml.jackson.annotation.JsonProperty

import java.util.*

@Entity(
        tableName = "manufacturer"
)
data class Manufacturer (
        @NonNull
        @PrimaryKey
        @ColumnInfo(name = "id")
        @JsonProperty("id")
        var id: Int,

        @ColumnInfo(name = "name")
        @JsonProperty("name")
        var name: String,

        @ColumnInfo(name = "created_at")
        @JsonProperty("created_at")
        var created_at: Date,

        @ColumnInfo(name = "updated_at")
        @JsonProperty("updated_at")
        var updated_at: Date
)