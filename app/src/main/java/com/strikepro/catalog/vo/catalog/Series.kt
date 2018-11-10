package com.strikepro.catalog.vo.catalog

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

import java.util.*

@Entity(
        tableName = "series"
)
data class Series (
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    @JsonProperty("id")
    var id: Int,

    @ColumnInfo(name = "name")
    @JsonProperty("name")
    var name: String,

    @ColumnInfo(name = "distinctive_feature_id")
    @JsonProperty("distinctive_feature_id")
    var distinctive_feature_id: Int?,

    @ColumnInfo(name = "created_at")
    @JsonProperty("created_at")
    var created_at: Date,

    @ColumnInfo(name = "updated_at")
    @JsonProperty("updated_at")
    var updated_at: Date
) {
//    @Relation(
//            entity = Feature::class,
//            entityColumn = "id",
//            parentColumn = "distinctive_feature_id"
//    )
//    @JsonIgnore
//    lateinit var distinctiveFeature: Feature
}