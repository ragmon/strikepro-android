package com.strikepro.catalog.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.strikepro.catalog.viewmodel.CatalogViewModelFactory

import com.strikepro.catalog.ui.blog.BlogViewModel
import com.strikepro.catalog.viewmodel.blog.PostViewModel
import com.strikepro.catalog.viewmodel.catalog.ArticleViewModel
import com.strikepro.catalog.viewmodel.catalog.GroupViewModel
import com.strikepro.catalog.viewmodel.wherebuy.CityViewModel
import com.strikepro.catalog.viewmodel.wherebuy.StoreViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BlogViewModel::class)
    abstract fun bindCategoryViewModel(blogViewModel: BlogViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ArticleViewModel::class)
    abstract fun bindArticleViewModel(articleViewModel: ArticleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GroupViewModel::class)
    abstract fun bindGroupViewModel(groupViewModel: GroupViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CityViewModel::class)
    abstract fun bindCityViewModel(cityViewModel: CityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StoreViewModel::class)
    abstract fun bindStoreViewModel(storeViewModel: StoreViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: CatalogViewModelFactory): ViewModelProvider.Factory

}