package com.strikepro.catalog.vo.catalog

import androidx.annotation.NonNull
import androidx.room.*

import com.fasterxml.jackson.annotation.JsonProperty
import com.strikepro.catalog.db.converter.ResourceTypeConverter

import com.strikepro.catalog.vo.BaseFeedItem
import com.strikepro.catalog.vo.ResourceType

import java.util.*

@Entity(
        tableName = "article"
)
@TypeConverters(value = [
    ResourceTypeConverter::class
])
data class Article(
        @NonNull
        @PrimaryKey
        @ColumnInfo(name = "id")
        @JsonProperty("id")
        var id: Int,

        @ColumnInfo(name = "group_id")
        @JsonProperty("group_id")
        var group_id: Int,

        @ColumnInfo(name = "new")
        @JsonProperty("new")
        var new: Boolean,

        @ColumnInfo(name = "sale")
        @JsonProperty("sale")
        var sale: Boolean,

        @ColumnInfo(name = "code")
        @JsonProperty("code")
        var code: String,

        @ColumnInfo(name = "name")
        @JsonProperty("name")
        var name: String,

        @ColumnInfo(name = "fullname")
        @JsonProperty("fullname")
        var fullname: String,

        @ColumnInfo(name = "cols")
        @JsonProperty("cols")
        var cols: Int,

        @ColumnInfo(name = "og_url")
        @JsonProperty("og_url")
        var og_url: String,

        @ColumnInfo(name = "og_image")
        @JsonProperty("og_image")
        var og_image: String,

        @ColumnInfo(name = "og_type")
        @JsonProperty("og_type")
        var og_type: String,

        @ColumnInfo(name = "og_title")
        @JsonProperty("og_title")
        var og_title: String,

        @ColumnInfo(name = "meta_description")
        @JsonProperty("meta_description")
        var meta_description: String,

        @ColumnInfo(name = "meta_keywords")
        @JsonProperty("meta_keywords")
        var meta_keywords: String,

        @ColumnInfo(name = "meta_title")
        @JsonProperty("meta_title")
        var meta_title: String,

        @ColumnInfo(name = "manufacturer_id")
        @JsonProperty("manufacturer_id")
        var manufacturer_id: Int,

        @ColumnInfo(name = "in_stock")
        @JsonProperty("in_stock")
        var in_stock: Boolean,

        @ColumnInfo(name = "created_at")
        @JsonProperty("created_at")
        var created_at: Date,

        @ColumnInfo(name = "updated_at")
        @JsonProperty("updated_at")
        var updated_at: Date
) : BaseFeedItem(ResourceType.ARTICLE) {
    //        @Relation(
//                entity = Group::class,
//                entityColumn = "id",
//                parentColumn = "parent_id"
//        )
//        lateinit var group: Group
//
//        @Relation(
//                entity = Manufacturer::class,
//                entityColumn = "id",
//                parentColumn = "manufacturer_id"
//        )
//        lateinit var manufacturer: Manufacturer
    constructor() : this(
            0,
            0,
            false,
            false,
            "",
            "",
            "",
            0,
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            0,
            false,
            Date(),
            Date()
    )
}