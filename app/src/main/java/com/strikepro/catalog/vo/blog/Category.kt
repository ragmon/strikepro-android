package com.strikepro.catalog.vo.blog

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

import com.fasterxml.jackson.annotation.JsonProperty

import java.util.*

@Entity(
        tableName = "category"
)
data class Category (
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
) {
//        @Relation(
//                entity = Post::class,
//                entityColumn = "category_id",
//                parentColumn = "id"
//        )
//        lateinit var posts: List<Post>
}