package com.strikepro.catalog.vo.blog

import androidx.annotation.NonNull
import androidx.room.*

import com.fasterxml.jackson.annotation.JsonProperty
import com.strikepro.catalog.db.converter.ResourceTypeConverter

import com.strikepro.catalog.vo.BaseFeedItem
import com.strikepro.catalog.vo.ResourceType

import java.util.*

@Entity(
        tableName = "post"
)
@TypeConverters(value = [
        ResourceTypeConverter::class
])
data class Post (
        @NonNull
        @PrimaryKey
        @ColumnInfo(name = "id")
        @JsonProperty("id")
        var id: Int,

        @ColumnInfo(name = "category_id")
        @JsonProperty("category_id")
        var category_id: Int,

        @ColumnInfo(name = "title")
        @JsonProperty("title")
        var title: String,

        @ColumnInfo(name = "excerpt")
        @JsonProperty("excerpt")
        var excerpt: String,

        @ColumnInfo(name = "body")
        @JsonProperty("body")
        var body: String,

        @ColumnInfo(name = "tags")
        @JsonProperty("tags")
        var tags: String,

        @ColumnInfo(name = "image")
        @JsonProperty("image")
        var image: String,

        @ColumnInfo(name = "public_at")
        @JsonProperty("public_at")
        var public_at: Date,

        @ColumnInfo(name = "created_at")
        @JsonProperty("created_at")
        var created_at: Date
) : BaseFeedItem(ResourceType.POST) {
//        @Relation(
//                entity = Category::class,
//                parentColumn = "category_id",
//                entityColumn = "id"
//        )
//        @JsonIgnore
//        lateinit var category: Set<Category>
}