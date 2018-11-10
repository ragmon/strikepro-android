package com.strikepro.catalog.vo.wherebuy

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

import com.fasterxml.jackson.annotation.JsonProperty

import java.util.*

@Entity(
        tableName = "store"
)
data class Store (
        @NonNull
        @PrimaryKey
        @ColumnInfo(name = "id")
        @JsonProperty("id")
        var id: Int,

        @ColumnInfo(name = "name")
        @JsonProperty("name")
        var name: String,

        @ColumnInfo(name = "address")
        @JsonProperty("address")
        var address: String,

        @ColumnInfo(name = "site_url")
        @JsonProperty("site_url")
        var site_url: String,

        @ColumnInfo(name = "telephone")
        @JsonProperty("telephone")
        var telephone: String,

        @ColumnInfo(name = "order")
        @JsonProperty("order")
        var order: Int,

        @ColumnInfo(name = "city_id")
        @JsonProperty("city_id")
        var city_id: Int,

        @ColumnInfo(name = "lat")
        @JsonProperty("lat")
        var lat: Float,

        @ColumnInfo(name = "lng")
        @JsonProperty("lng")
        var lng: Float,

        @ColumnInfo(name = "created_at")
        @JsonProperty("created_at")
        var created_at: Date,

        @ColumnInfo(name = "updated_at")
        @JsonProperty("updated_at")
        var updated_at: Date
) {
//        @Relation(
//                entity = City::class,
//                entityColumn = "id",
//                parentColumn = "city_id"
//        )
//        lateinit var city: City
}