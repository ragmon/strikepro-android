package com.strikepro.catalog.service

import androidx.lifecycle.LiveData
import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.vo.Feedback

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FeedbackService {
    @POST("api/v1/feedback")
    fun send(@Body feedback: Feedback)

    @GET("api/v1/feedback")
    fun list(): LiveData<ApiResponse<List<Feedback>>>
}