package com.strikepro.catalog.vo.wherebuy

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
        primaryKeys = ["id"],
        foreignKeys = [
//            ForeignKey(
//                    entity = City::class,
//                    parentColumns = ["id"],
//                    childColumns = ["city_id"]
//            )
        ]
)
data class Store (
        var id: Int,
        var name: String,
        var address: String,
        var site_url: String,
        var telephone: String,
        var order: Int,
        var city_id: Int,
        var lat: Float,
        var lng: Float,
        var created_at: String,
        var updated_at: String
)