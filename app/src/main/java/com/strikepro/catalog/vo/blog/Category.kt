package com.strikepro.catalog.vo.blog

import android.arch.persistence.room.Entity

@Entity(
        primaryKeys = ["id"]
)
data class Category (
        var id: Int,
        var name: String,
        var created_at: String,
        var updated_at: String
)