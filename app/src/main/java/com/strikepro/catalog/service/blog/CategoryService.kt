package com.strikepro.catalog.service.blog

import com.strikepro.catalog.vo.blog.Category
import retrofit2.Call
import retrofit2.http.GET

interface CategoryService {
    @GET("api/v1/blog/categories")
    fun list(): Call<List<Category>>
}