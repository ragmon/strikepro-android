package com.strikepro.catalog.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.strikepro.catalog.viewmodel.CatalogViewModelFactory

import com.strikepro.catalog.ui.blog.BlogViewModel
import com.strikepro.catalog.ui.catalog.CatalogViewModel
import com.strikepro.catalog.ui.main.FeedViewModel
import com.strikepro.catalog.ui.wherebuy.WherebuyViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    abstract fun bindFeedViewModel(feedViewModel: FeedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BlogViewModel::class)
    abstract fun bindBlogViewModel(blogViewModel: BlogViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CatalogViewModel::class)
    abstract fun bindCatalogViewModel(catalogViewModel: CatalogViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WherebuyViewModel::class)
    abstract fun bindWherebuyViewModel(wherebuyViewModel: WherebuyViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: CatalogViewModelFactory): ViewModelProvider.Factory

}