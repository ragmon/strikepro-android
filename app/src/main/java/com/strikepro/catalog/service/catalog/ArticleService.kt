package com.strikepro.catalog.service.catalog

import android.arch.lifecycle.LiveData
import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.vo.catalog.Article
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleService {
    @GET("catalog/article/{id}")
    fun find(
            @Path("id") id: Int
    ): Call<Article>

    @GET("catalog/articles/{groupId}")
    fun list(
            @Path("groupId") groupId: Int,
            @Query("page") page: Int = 1
    ): LiveData<ApiResponse<List<Article>>>
}