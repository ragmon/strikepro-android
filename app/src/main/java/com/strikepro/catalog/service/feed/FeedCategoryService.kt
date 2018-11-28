package com.strikepro.catalog.service.feed

import androidx.lifecycle.LiveData

import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.vo.main.FeedCategory

import retrofit2.http.GET

interface FeedCategoryService {
    @GET("feed/categories")
    fun list(): LiveData<ApiResponse<List<FeedCategory>>>
}