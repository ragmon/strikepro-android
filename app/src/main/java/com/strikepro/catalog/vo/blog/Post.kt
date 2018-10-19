package com.strikepro.catalog.vo.blog

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE

@Entity(
        primaryKeys = ["id"],
        foreignKeys = [
            ForeignKey(
                    entity = Category::class,
                    parentColumns = ["id"],
                    childColumns = ["category_id"],
                    onDelete = CASCADE
            )
        ]
)
data class Post(
        var id: Int,
        var category_id: Int,
        var title: String,
        var excerpt: String,
        var body: String,
        var tags: String,
        var image: String,
        var public_at: String,
        var created_at: String
)