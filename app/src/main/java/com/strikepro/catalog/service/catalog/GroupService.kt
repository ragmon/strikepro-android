package com.strikepro.catalog.service.catalog

import com.strikepro.catalog.vo.catalog.Group
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GroupService {
    @GET("catalog")
    fun list(
            @Query("page") page: Int = 1
    ): Call<List<Group>>

    @GET("catalog/group/{parent_id}")
    fun listByParent(
            @Path("parent_id") parentId: Int,
            @Query("page") page: Int = 1
    ): Call<List<Group>>
}