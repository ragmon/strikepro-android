package com.strikepro.catalog.service.catalog

import androidx.lifecycle.LiveData

import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.vo.catalog.Series

import retrofit2.http.GET

interface SeriesService {
    @GET("catalog/series")
    fun list(): LiveData<ApiResponse<List<Series>>>
}