package com.strikepro.catalog.vo.wherebuy

import android.arch.persistence.room.Entity

@Entity(
        primaryKeys = ["id"]
)
data class City (
        var id: Int,
        var country_id: Int,
        var name: String,
        var lng: Float,
        var lat: Float,
        var created_at: String,
        var updated_at: String
)