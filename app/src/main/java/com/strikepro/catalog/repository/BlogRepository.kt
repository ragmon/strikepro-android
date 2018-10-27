package com.strikepro.catalog.repository

import android.arch.lifecycle.LiveData
import com.strikepro.catalog.api.ApiResponse

import com.strikepro.catalog.api.Resource
import com.strikepro.catalog.common.AppExecutors
import com.strikepro.catalog.common.POST_SYNC_TIMEOUT
import com.strikepro.catalog.db.blog.CategoryDAO
import com.strikepro.catalog.db.blog.PostDAO
import com.strikepro.catalog.service.blog.CategoryService
import com.strikepro.catalog.service.blog.PostService
import com.strikepro.catalog.util.RateLimiter
import com.strikepro.catalog.vo.blog.Category
import com.strikepro.catalog.vo.blog.Post

import java.util.concurrent.TimeUnit

import javax.inject.Inject

class BlogRepository @Inject constructor(
        private val appExecutors: AppExecutors,
        private val categoryDAO: CategoryDAO,
        private val postDAO: PostDAO,
        private val categoryService: CategoryService,
        private val postService: PostService
) {
    private val postRateLimit = RateLimiter<Int?>(POST_SYNC_TIMEOUT, TimeUnit.MINUTES)

    fun loadCategoryList(): LiveData<Resource<List<Category>>> {
        return object : NetworkBoundResource<List<Category>, List<Category>>(appExecutors) {
            override fun saveCallResult(item: List<Category>) {
                categoryDAO.insert(item)
            }

            override fun createCall(): LiveData<ApiResponse<List<Category>>> = categoryService.list()

            override fun loadFromDB(): LiveData<List<Category>> = categoryDAO.loadAll()

            override fun shouldFetch(data: List<Category>?): Boolean = data == null || data.isEmpty()
        }.asLiveData()
    }

    fun loadPostList(categoryID: Int?): LiveData<Resource<List<Post>>> {
        return object : NetworkBoundResource<List<Post>, List<Post>>(appExecutors) {
            override fun createCall(): LiveData<ApiResponse<List<Post>>>
                    = if (categoryID != null) postService.categoryList(categoryID) else postService.list()

            override fun loadFromDB(): LiveData<List<Post>> = postDAO.loadList()

            override fun saveCallResult(item: List<Post>) {
                postDAO.insert(item)
            }

            override fun shouldFetch(data: List<Post>?): Boolean = data == null || data.isEmpty()
                    || postRateLimit.shouldFetch(categoryID)
        }.asLiveData()
    }
}