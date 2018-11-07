package com.strikepro.catalog.service.wherebuy

import androidx.lifecycle.LiveData

import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.vo.wherebuy.City

import retrofit2.http.GET

interface CityService {
    @GET("cities")
    fun list(): LiveData<ApiResponse<List<City>>>
}