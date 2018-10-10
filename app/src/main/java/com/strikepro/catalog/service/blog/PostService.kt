package com.strikepro.catalog.service.blog

import com.strikepro.catalog.model.blog.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {
    @GET("blog")
    fun list(
            @Query("page") page: Int = 1
    ): Call<List<Post>>

    @GET("blog/category/{id}")
    fun categoryList(
            @Path("id") id: Int,
            @Query("page") page: Int = 1
    ): Call<List<Post>>
}