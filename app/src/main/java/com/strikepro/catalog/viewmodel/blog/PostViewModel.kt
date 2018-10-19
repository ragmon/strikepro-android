package com.strikepro.catalog.viewmodel.blog

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.strikepro.catalog.vo.blog.Post

class PostViewModel: ViewModel() {
    private lateinit var posts: MutableLiveData<List<Post>>

    fun getPosts(): LiveData<List<Post>> {
        if (!::posts.isInitialized) {
            posts = MutableLiveData()
            loadPosts()
        }
        return posts
    }

    private fun loadPosts() {
        // Do an asynchronous operation to fetch posts
    }
}