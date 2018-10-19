package com.strikepro.catalog.viewmodel.blog

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.strikepro.catalog.vo.blog.Category

class CategoryViewModel: ViewModel() {
    private lateinit var categories: MutableLiveData<List<Category>>

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
}