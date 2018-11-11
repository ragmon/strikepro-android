package com.strikepro.catalog.service.catalog

import androidx.lifecycle.LiveData

import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.vo.catalog.Type

import retrofit2.http.GET

interface TypeService {
    @GET("catalog/types")
    fun list(): LiveData<ApiResponse<List<Type>>>
}