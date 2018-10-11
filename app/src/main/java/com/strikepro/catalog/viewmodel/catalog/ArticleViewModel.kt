package com.strikepro.catalog.viewmodel.catalog

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.strikepro.catalog.model.catalog.Article

class ArticleViewModel: ViewModel() {
    private lateinit var articles: MutableLiveData<List<Article>>

    fun getArticles(): LiveData<List<Article>> {
        if (!::articles.isInitialized) {
            articles = MutableLiveData()
            loadArticles()
        }
        return articles
    }

    private fun loadArticles() {
        // Do an asynchronous operation to fetch articles
    }
}