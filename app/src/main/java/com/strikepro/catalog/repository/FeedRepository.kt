package com.strikepro.catalog.repository

import android.arch.lifecycle.LiveData

import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.api.Resource

import com.strikepro.catalog.common.AppExecutors
import com.strikepro.catalog.common.FEED_SYNC_TIMEOUT
import com.strikepro.catalog.db.FeedDAO
import com.strikepro.catalog.service.FeedService

import com.strikepro.catalog.util.RateLimiter

import com.strikepro.catalog.vo.ResourceType
import com.strikepro.catalog.vo.main.FeedItem

import java.util.concurrent.TimeUnit

import javax.inject.Inject

class FeedRepository @Inject constructor(
        private val appExecutors: AppExecutors,
        private val feedDAO: FeedDAO,
        private val feedService: FeedService
) {
    private val feedRateLimit = RateLimiter<ResourceType?>(FEED_SYNC_TIMEOUT, TimeUnit.MINUTES)

    fun loadItemList(resourceType: ResourceType): LiveData<Resource<List<FeedItem>>> {
        return object : NetworkBoundResource<List<FeedItem>, List<FeedItem>>(appExecutors) {
            override fun saveCallResult(item: List<FeedItem>) {
                feedDAO.insert(item)
            }

            override fun createCall(): LiveData<ApiResponse<List<FeedItem>>> = feedService.list()

            override fun loadFromDB(): LiveData<List<FeedItem>> = feedDAO.loadAll()

            override fun shouldFetch(data: List<FeedItem>?): Boolean = data == null || data.isEmpty()
                    || feedRateLimit.shouldFetch(resourceType)
        }.asLiveData()
    }
}