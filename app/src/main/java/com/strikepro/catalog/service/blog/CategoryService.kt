package com.strikepro.catalog.service.blog

import com.strikepro.catalog.model.blog.Category
import retrofit2.Call
import retrofit2.http.GET

interface CategoryService {
    @GET("blog/categories")
    fun list(): Call<List<Category>>
}