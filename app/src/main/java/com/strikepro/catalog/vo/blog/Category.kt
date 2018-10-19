package com.strikepro.catalog.vo.blog

import android.arch.persistence.room.Entity

@Entity(
     primaryKeys = ["id"]
     // TODO: define foreign keys
)
data class Category (
        var id: Int,
        var name: String
)