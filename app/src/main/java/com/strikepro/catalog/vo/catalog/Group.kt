package com.strikepro.catalog.vo.catalog

import androidx.annotation.NonNull
import androidx.room.*

import com.fasterxml.jackson.annotation.JsonProperty

import com.strikepro.catalog.db.converter.ResourceTypeConverter
import com.strikepro.catalog.vo.BaseFeedItem
import com.strikepro.catalog.vo.Country
import com.strikepro.catalog.vo.ResourceType

import java.util.*

@Entity(
        tableName = "group"
)
@TypeConverters(value = [
    ResourceTypeConverter::class
])
data class Group(
        @NonNull
        @PrimaryKey
        @ColumnInfo(name = "id")
        @JsonProperty("id")
        var id: Int,

        @ColumnInfo(name = "is_product")
        @JsonProperty("is_product")
        var isProduct: Boolean?,

        @ColumnInfo(name = "series_id")
        @JsonProperty("series_id")
        var series_id: Int?,

        @ColumnInfo(name = "parent_id")
        @JsonProperty("parent_id")
        var parent_id: Int?,

        @ColumnInfo(name = "country_id")
        @JsonProperty("country_id")
        var country_id: Int?,

        @ColumnInfo(name = "manufacturer_id")
        @JsonProperty("manufacturer_id")
        var manufacturer_id: Int?,

        @ColumnInfo(name = "seasonality_id")
        @JsonProperty("seasonality_id")
        var seasonality_id: Int?,

        @ColumnInfo(name = "type_id")
        @JsonProperty("type_id")
        var type_id: Int?,

        @ColumnInfo(name = "new")
        @JsonProperty("new")
        var new: Boolean,

        @ColumnInfo(name = "sale")
        @JsonProperty("sale")
        var sale: Boolean,

        @ColumnInfo(name = "code")
        @JsonProperty("code")
        var code: String?,

        @ColumnInfo(name = "name")
        @JsonProperty("name")
        var name: String,

        @ColumnInfo(name = "fullname")
        @JsonProperty("fullname")
        var fullname: String,

        @ColumnInfo(name = "description")
        @JsonProperty("description")
        var description: String,

        @ColumnInfo(name = "created_at")
        @JsonProperty("created_at")
        var created_at: Date,

        @ColumnInfo(name = "updated_at")
        @JsonProperty("updated_at")
        var updated_at: Date
) : BaseFeedItem(ResourceType.GROUP) {
    //        @Relation(
//                entity = Series::class,
//                entityColumn = "id",
//                parentColumn = "series_id"
//        )
//        lateinit var series: Series
//
//        @Relation(
//                entity = Group::class,
//                entityColumn = "id",
//                parentColumn = "parent_id"
//        )
//        lateinit var parent: Group
//
//        @Relation(
//                entity = Country::class,
//                entityColumn = "id",
//                parentColumn = "country_id"
//        )
//        lateinit var country: Country
//
//        @Relation(
//                entity = Manufacturer::class,
//                entityColumn = "id",
//                parentColumn = "manufacturer_id"
//        )
//        lateinit var manufacturer: Manufacturer
//
//        @Relation(
//                entity = Seasonality::class,
//                entityColumn = "id",
//                parentColumn = "seasonality_id"
//        )
//        lateinit var seasonality: Seasonality
    constructor() : this(
            0,
            false,
            null,
            null,
            null,
            null,
            null,
            null,
            false,
            false,
            null,
            "",
            "",
            "",
            Date(),
            Date()
    )
}