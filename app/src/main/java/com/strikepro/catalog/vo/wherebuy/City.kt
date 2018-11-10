package com.strikepro.catalog.vo.wherebuy

import androidx.annotation.NonNull
import androidx.room.*

import com.fasterxml.jackson.annotation.JsonProperty

import com.strikepro.catalog.vo.Country

import java.util.*

@Entity(
        tableName = "city"
)
data class City(
        @NonNull
        @PrimaryKey
        @ColumnInfo(name = "id")
        @JsonProperty("id")
        var id: Int,

        @ColumnInfo(name = "country_id")
        @JsonProperty("country_id")
        var country_id: Int,

        @ColumnInfo(name = "name")
        @JsonProperty("name")
        var name: String,

        @ColumnInfo(name = "lng")
        @JsonProperty("lng")
        var lng: Float,

        @ColumnInfo(name = "lat")
        @JsonProperty("lat")
        var lat: Float,

        @ColumnInfo(name = "created_at")
        @JsonProperty("created_at")
        var created_at: Date,

        @ColumnInfo(name = "updated_at")
        @JsonProperty("updated_at")
        var updated_at: Date
) {
    //        @Relation(
//                entity = Country::class,
//                entityColumn = "id",
//                parentColumn = "country_id"
//        )
//    @Embedded
//    lateinit var country: Country
}