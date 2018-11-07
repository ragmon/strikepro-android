package com.strikepro.catalog.vo.catalog

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE

import com.strikepro.catalog.vo.BaseFeedItem
import com.strikepro.catalog.vo.ResourceType

@Entity(
        primaryKeys = ["id"],
        foreignKeys = [
//            ForeignKey(
//                    entity = Group::class,
//                    parentColumns = ["id"],
//                    childColumns = ["parent_id"],
//                    onDelete = CASCADE
//            )
        ]
)
data class Group (
        val id: Int,
        val is_product: Boolean,
        val series_id: Int?,
        val parent_id: Int?,
        val country_id: Int,
        val manufacturer_id: Int?,
        val seasonality_id: Int?,
        val type_id: Int?,
        val new: Boolean,
        val sale: Boolean,
        val code: String,
        val name: String,
        val fullname: String,
        val description: String,
        val created_at: String,
        val updated_at: String
)