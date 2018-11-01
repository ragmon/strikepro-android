package com.strikepro.catalog.vo

// Available resource types.
const val TYPE_UNKNOWN = "unknown"
const val TYPE_ALL = "all"
const val TYPE_POST = "post"
const val TYPE_GROUP = "group"
const val TYPE_ARTICLE = "article"

/**
 * Polymorphic resource type.
 */
enum class ResourceType(val type: String = TYPE_UNKNOWN) {
    UNKNOWN(TYPE_UNKNOWN),
    ALL(TYPE_ALL),
    POST(TYPE_POST),
    GROUP(TYPE_GROUP),
    ARTICLE(TYPE_ARTICLE),
}