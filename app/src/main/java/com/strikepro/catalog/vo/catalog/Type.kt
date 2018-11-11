package com.strikepro.catalog.vo.catalog

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import com.fasterxml.jackson.annotation.JsonProperty

import java.util.*

@Entity(
        tableName = "type"
)
data class Type (
        @NonNull
        @PrimaryKey
        @ColumnInfo(name = "id")
        @JsonProperty("id")
        var id: Int,

        @ColumnInfo(name = "title")
        @JsonProperty("title")
        var title: String,

        @ColumnInfo(name = "description")
        @JsonProperty("description")
        var description: String,

        @ColumnInfo(name = "template")
        @JsonProperty("template")
        var template: String,

        @ColumnInfo(name = "createdAt")
        @JsonProperty("createdAt")
        var createdAt: Date,

        @ColumnInfo(name = "updatedAt")
        @JsonProperty("updatedAt")
        var updatedAt: Date
)