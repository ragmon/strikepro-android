package com.strikepro.catalog.di.builder

import com.strikepro.catalog.ui.blog.BlogFragment
import com.strikepro.catalog.ui.blog.PostFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class BlogActivityFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeBlogFragment(): BlogFragment

    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostFragment

}