package com.strikepro.catalog.service.blog

import android.arch.lifecycle.LiveData
import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.vo.blog.Category

import retrofit2.http.GET

interface CategoryService {
    @GET("api/v1/blog/categories")
    fun list(): LiveData<ApiResponse<List<Category>>>
}