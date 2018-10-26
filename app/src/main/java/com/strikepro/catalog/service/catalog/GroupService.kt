package com.strikepro.catalog.service.catalog

import android.arch.lifecycle.LiveData

import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.vo.catalog.Group

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GroupService {
    @GET("catalog")
    fun list(
            @Query("page") page: Int = 1
    ): LiveData<ApiResponse<List<Group>>>

    @GET("catalog/group/{parent_id}")
    fun listByParent(
            @Path("parent_id") parentId: Int,
            @Query("page") page: Int = 1
    ): LiveData<ApiResponse<List<Group>>>
}