package com.strikepro.catalog.repository

import androidx.lifecycle.LiveData

import com.strikepro.catalog.api.ApiResponse
import com.strikepro.catalog.api.Resource
import com.strikepro.catalog.common.ARTICLE_SYNC_TIMEOUT
import com.strikepro.catalog.common.GROUP_SYNC_TIMEOUT
import com.strikepro.catalog.common.AppExecutors

import com.strikepro.catalog.db.catalog.ArticleDAO
import com.strikepro.catalog.db.catalog.GroupDAO
import com.strikepro.catalog.service.catalog.ArticleService
import com.strikepro.catalog.service.catalog.GroupService
import com.strikepro.catalog.util.RateLimiter
import com.strikepro.catalog.vo.catalog.Article
import com.strikepro.catalog.vo.catalog.Group

import java.util.concurrent.TimeUnit

import javax.inject.Inject

class CatalogRepository @Inject constructor(
        private val appExecutors: AppExecutors,
        private val groupDAO: GroupDAO,
        private val groupService: GroupService,
        private val articleDAO: ArticleDAO,
        private val articleService: ArticleService
) {
    private val groupRateLimiter = RateLimiter<Int?>(GROUP_SYNC_TIMEOUT, TimeUnit.MINUTES)
    private val articleRateLimit = RateLimiter<Int>(ARTICLE_SYNC_TIMEOUT, TimeUnit.MINUTES)

    fun loadGroupList(parentID: Int?): LiveData<Resource<List<Group>>> {
        return object : NetworkBoundResource<List<Group>, List<Group>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Group>>
                    = if (parentID == null) groupDAO.loadRootList() else groupDAO.loadList(parentID)

            override fun createCall(): LiveData<ApiResponse<List<Group>>>
                    = if (parentID != null) groupService.listByParent(parentID) else groupService.list()

            override fun saveCallResult(item: List<Group>) {
                groupDAO.insert(item)
            }

            override fun shouldFetch(data: List<Group>?): Boolean = data == null || data.isEmpty()
                    || groupRateLimiter.shouldFetch(parentID)
        }.asLiveData()
    }

    fun loadArticleList(groupID: Int): LiveData<Resource<List<Article>>> {
        return object : NetworkBoundResource<List<Article>, List<Article>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Article>> = articleDAO.loadList(groupID)

            override fun createCall(): LiveData<ApiResponse<List<Article>>> = articleService.list(groupID)

            override fun saveCallResult(item: List<Article>) {
                articleDAO.insert(item)
            }

            override fun shouldFetch(data: List<Article>?): Boolean = data == null || data.isEmpty()
                    || articleRateLimit.shouldFetch(groupID)
        }.asLiveData()
    }
}