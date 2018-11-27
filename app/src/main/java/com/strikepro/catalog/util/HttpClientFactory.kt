package com.strikepro.catalog.util

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class HttpClientFactory {
    companion object {
        @JvmStatic
        fun create(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
        }
    }
}