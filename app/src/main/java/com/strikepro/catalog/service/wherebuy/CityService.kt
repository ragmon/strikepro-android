package com.strikepro.catalog.service.wherebuy

import com.strikepro.catalog.vo.wherebuy.City
import retrofit2.Call
import retrofit2.http.GET

interface CityService {
    @GET("cities")
    fun list(): Call<List<City>>
}