package com.strikepro.catalog.vo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import com.fasterxml.jackson.annotation.JsonProperty

import java.util.*

@Entity(
        tableName = "feedback"
)
data class Feedback(
        @NonNull
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        @JsonProperty("id")
        var id: Int,

        @ColumnInfo(name = "type")
        @JsonProperty("type")
        var type: String,

        @ColumnInfo(name = "message")
        @JsonProperty("message")
        var message: String,

        @ColumnInfo(name = "created_at")
        @JsonProperty("created_at")
        var created_at: Date
)