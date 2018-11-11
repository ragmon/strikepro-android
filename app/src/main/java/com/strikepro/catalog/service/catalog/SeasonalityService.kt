package com.strikepro.catalog.service.catalog

import androidx.lifecycle.LiveData

import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.vo.catalog.Seasonality

import retrofit2.http.GET

interface SeasonalityService {
    @GET("catalog/seasonality")
    fun list(): LiveData<ApiResponse<List<Seasonality>>>
}