package com.strikepro.catalog.service.wherebuy

import com.strikepro.catalog.model.wherebuy.Store
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreService {
    @GET("stores/{city_id}")
    fun list(
            @Path("city_id") cityId: Int
    ): Call<List<Store>>
}