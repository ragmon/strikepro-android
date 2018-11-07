package com.strikepro.catalog.service.feed

import androidx.lifecycle.LiveData

import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.vo.main.FeedItem

import retrofit2.http.GET
import retrofit2.http.Query

interface FeedService {
    @GET("feed")
    fun list(
            @Query("page") page: Int = 1
    ): LiveData<ApiResponse<List<FeedItem>>>
}