package com.strikepro.catalog.ui.blog

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

import com.strikepro.catalog.vo.blog.Category
import com.strikepro.catalog.vo.blog.Post

import javax.inject.Inject

class BlogViewModel
@Inject constructor(
        categoryRepository: CategoryRepository,
        postRepository: PostRepository
): ViewModel() {
    private lateinit var categories: MutableLiveData<List<Category>>
    private lateinit var selectedCategory: MutableLiveData<Category>
    private lateinit var posts: MutableLiveData<List<Post>>

    fun getCategories(): LiveData<List<Category>> {
        if (!::categories.isInitialized) {
            categories = MutableLiveData()
            loadCategories()
        }
        return categories
    }

    private fun loadCategories() {
        // Do an asynchronous operation to fetch categories
    }

    fun selectCategory(category: Category) {
        selectedCategory.value = category
    }

    fun getSelectedCategory(): LiveData<Category> {
        if (!::selectedCategory.isInitialized) {
            selectedCategory = MutableLiveData()
        }
        return selectedCategory
    }

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