package com.strikepro.catalog.service.catalog

import androidx.lifecycle.LiveData

import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.vo.catalog.Feature

import retrofit2.http.GET

interface FeatureService {
    @GET("catalog/features")
    fun list(): LiveData<ApiResponse<List<Feature>>>
}