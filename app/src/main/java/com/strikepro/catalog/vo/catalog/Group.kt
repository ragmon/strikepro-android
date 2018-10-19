package com.strikepro.catalog.vo.catalog

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE

@Entity(
        primaryKeys = ["id"],
        foreignKeys = [
            ForeignKey(
                    entity = Group::class,
                    parentColumns = ["id"],
                    childColumns = ["parent_id"],
                    onDelete = CASCADE
            )
        ]
)
data class Group (
        var id: Int,
        var is_product: Boolean,
        var series_id: Int,
        var parent_id: Int,
        var country_id: Int,
        var manufacturer_id: Int,
        var seasonality_id: Int,
        var type_id: Int,
        var new: Boolean,
        var sale: Boolean,
        var code: String,
        var name: String,
        var fullname: String,
        var description: String,
        var cols: Int,
        var og_url: String,
        var og_image: String,
        var og_type: String,
        var og_title: String,
        var meta_description: String,
        var meta_keywords: String,
        var meta_title: String,
        var created_at: String,
        var updated_at: String
)