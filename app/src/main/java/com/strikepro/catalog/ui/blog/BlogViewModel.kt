package com.strikepro.catalog.ui.blog

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

import com.strikepro.catalog.api.Resource
import com.strikepro.catalog.repository.BlogRepository
import com.strikepro.catalog.util.AbsentLiveData
import com.strikepro.catalog.vo.blog.Category
import com.strikepro.catalog.vo.blog.Post

import javax.inject.Inject

class BlogViewModel @Inject constructor(
        private val blogRepository: BlogRepository
): ViewModel() {
    private val categories = blogRepository.loadCategoryList()
    private val selectedCategory = MutableLiveData<Category>()
    private val posts: LiveData<Resource<List<Post>>> = Transformations
            .switchMap(selectedCategory) { selectedCategory ->
                if (selectedCategory == null)
                    AbsentLiveData.create()
                else
                    blogRepository.loadPostList(selectedCategory.id)
            }

    fun getCategories() = categories

    fun selectCategory(category: Category) {
        selectedCategory.value = category
    }

    fun getSelectedCategory(): LiveData<Category> = selectedCategory

    fun getPosts(): LiveData<Resource<List<Post>>> = posts
}