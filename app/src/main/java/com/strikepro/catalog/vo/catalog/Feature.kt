package com.strikepro.catalog.vo.catalog

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

import com.fasterxml.jackson.annotation.JsonProperty

import com.strikepro.catalog.db.converter.ValueTypeConverter

import java.util.*

/**
 * Feature entity data class.
 *
 * @property id
 * @property title
 * @property measurement
 * @property description
 * @property is_filter
 * @property value_type
 * @property created_at
 * @property updated_at
 */
@Entity(
        tableName = "feature"
)
@TypeConverters(value = [
    ValueTypeConverter::class
])
data class Feature (
        @NonNull
        @PrimaryKey
        @ColumnInfo(name = "id")
        @JsonProperty("id")
        var id: Int,

        @ColumnInfo(name = "title")
        @JsonProperty("title")
        var title: String,

        @ColumnInfo(name = "measurement")
        @JsonProperty("measurement")
        var measurement: String,

        @ColumnInfo(name = "description")
        @JsonProperty("description")
        var description: String,

        @ColumnInfo(name = "is_filter")
        @JsonProperty("is_filter")
        var is_filter: Boolean,

        @ColumnInfo(name = "value_type")
        @JsonProperty("value_type")
        var value_type: ValueType,

        @ColumnInfo(name = "created_at")
        @JsonProperty("created_at")
        var created_at: Date,

        @ColumnInfo(name = "updated_at")
        @JsonProperty("updated_at")
        var updated_at: Date
)


// Value type constants
const val VALUE_TYPE_UNKNOWN = "unknown"
const val VALUE_TYPE_STRING = "string"
const val VALUE_TYPE_INT = "int"
const val VALUE_TYPE_FLOAT = "float"
const val VALUE_TYPE_BOOL = "bool"

/**
 * Value type enum class.
 *
 * @property type
 */
enum class ValueType(val type: String = VALUE_TYPE_UNKNOWN) {
    UNKNOWN(VALUE_TYPE_UNKNOWN),
    STRING(VALUE_TYPE_STRING),
    INT(VALUE_TYPE_INT),
    FLOAT(VALUE_TYPE_FLOAT),
    BOOL(VALUE_TYPE_BOOL)
}