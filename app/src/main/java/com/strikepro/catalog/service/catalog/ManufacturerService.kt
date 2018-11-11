package com.strikepro.catalog.service.catalog

import androidx.lifecycle.LiveData

import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.vo.catalog.Manufacturer

import retrofit2.http.GET

interface ManufacturerService {
    @GET("catalog/series")
    fun list(): LiveData<ApiResponse<List<Manufacturer>>>
}