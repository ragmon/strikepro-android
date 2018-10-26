package com.strikepro.catalog.service

import com.strikepro.catalog.vo.Feedback

import retrofit2.http.Body
import retrofit2.http.POST

interface FeedbackService {
    @POST("api/v1/feedback")
    fun send(@Body feedback: Feedback)
}