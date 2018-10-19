package com.strikepro.catalog.vo.catalog

class Group (
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