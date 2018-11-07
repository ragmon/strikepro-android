package com.strikepro.catalog.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

import com.strikepro.catalog.api.Resource
import com.strikepro.catalog.repository.FeedRepository
import com.strikepro.catalog.util.AbsentLiveData
import com.strikepro.catalog.vo.main.FeedCategory
import com.strikepro.catalog.vo.main.FeedItem

import javax.inject.Inject

class FeedViewModel @Inject constructor(
        private val feedRepository: FeedRepository
): ViewModel() {
    private val categories: LiveData<Resource<List<FeedCategory>>> = feedRepository.loadCategories()
    private val selectedCategory: MutableLiveData<FeedCategory> = MutableLiveData()
    private val items: LiveData<Resource<List<FeedItem>>> = Transformations
            .switchMap(selectedCategory) { selectedCategory ->
                if (selectedCategory == null)
                    AbsentLiveData.create()
                else
                    feedRepository.loadItemList(selectedCategory.resource_type)
            }

    fun selectCategory(category: FeedCategory) {
        selectedCategory.value = category
    }
    fun getSelectedCategory(): LiveData<FeedCategory> = selectedCategory
}