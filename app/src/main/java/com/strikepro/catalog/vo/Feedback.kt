package com.strikepro.catalog.vo

import androidx.room.Entity

@Entity(
        primaryKeys = ["id"]
)
data class Feedback (
        var id: Int?,
        var type: String,
        var message: String,
        var created_at: String
)