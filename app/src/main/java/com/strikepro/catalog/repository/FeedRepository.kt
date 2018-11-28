package com.strikepro.catalog.repository

import androidx.lifecycle.LiveData

import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.api.Resource
import com.strikepro.catalog.common.AppExecutors
import com.strikepro.catalog.common.FEED_SYNC_TIMEOUT
import com.strikepro.catalog.db.feed.FeedCategoryDAO
import com.strikepro.catalog.db.feed.FeedDAO
import com.strikepro.catalog.service.feed.FeedCategoryService
import com.strikepro.catalog.service.feed.FeedService

import com.strikepro.catalog.util.RateLimiter

import com.strikepro.catalog.vo.ResourceType
import com.strikepro.catalog.vo.main.FeedCategory
import com.strikepro.catalog.vo.main.FeedItem

import java.util.concurrent.TimeUnit

import javax.inject.Inject

class FeedRepository @Inject constructor(
        private val appExecutors: AppExecutors,
        private val feedCategoryDAO: FeedCategoryDAO,
        private val feedCategoryService: FeedCategoryService,
        private val feedDAO: FeedDAO,
        private val feedService: FeedService
) {
    private val feedCategoryRateLimit = RateLimiter<String>(FEED_SYNC_TIMEOUT, TimeUnit.MINUTES)
    private val feedItemRateLimit = RateLimiter<ResourceType?>(FEED_SYNC_TIMEOUT, TimeUnit.MINUTES)

    fun loadCategories(): LiveData<Resource<List<FeedCategory>>> {
        return object : NetworkBoundResource<List<FeedCategory>, List<FeedCategory>>(appExecutors) {
            override fun saveCallResult(item: List<FeedCategory>) {
                feedCategoryDAO.insert(item)
            }

            override fun createCall(): LiveData<ApiResponse<List<FeedCategory>>> = feedCategoryService.list()

            override fun loadFromDB(): LiveData<List<FeedCategory>> = feedCategoryDAO.loadAll()

            override fun shouldFetch(data: List<FeedCategory>?): Boolean = data == null || data.isEmpty()
                    || feedCategoryRateLimit.shouldFetch("feed_categories")
        }.asLiveData()
    }

    fun loadItemList(resourceType: ResourceType = ResourceType.ALL): LiveData<Resource<List<FeedItem>>> {
        return object : NetworkBoundResource<List<FeedItem>, List<FeedItem>>(appExecutors) {
            override fun saveCallResult(item: List<FeedItem>) {
                feedDAO.insert(item)
            }

            override fun createCall(): LiveData<ApiResponse<List<FeedItem>>> = feedService.list()

            override fun loadFromDB(): LiveData<List<FeedItem>> = feedDAO.loadAll()

            override fun shouldFetch(data: List<FeedItem>?): Boolean = data == null || data.isEmpty()
                    || feedItemRateLimit.shouldFetch(resourceType)
        }.asLiveData()
    }
}