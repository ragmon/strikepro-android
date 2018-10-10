package com.strikepro.catalog.model.catalog

class Article (
        var id: Int,
        var group_id: Int,
        var new: Boolean,
        var sale: Boolean,
        var code: String,
        var name: String,
        var fullname: String,
        var cols: Int,
        var og_url: String,
        var og_image: String,
        var og_type: String,
        var og_title: String,
        var meta_description: String,
        var meta_keywords: String,
        var meta_title: String,
        var manyfacturer_id: Int,
        var in_stock: Boolean,
        var created_at: String,
        var updated_at: String
)