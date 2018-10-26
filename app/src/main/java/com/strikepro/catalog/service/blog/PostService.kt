package com.strikepro.catalog.service.blog

import android.arch.lifecycle.LiveData
import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.vo.blog.Post

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {
    @GET("blog")
    fun list(
            @Query("page") page: Int = 1
    ): LiveData<ApiResponse<List<Post>>>

    @GET("blog/category/{id}")
    fun categoryList(
            @Path("id") id: Int,
            @Query("page") page: Int = 1
    ): LiveData<ApiResponse<List<Post>>>
}