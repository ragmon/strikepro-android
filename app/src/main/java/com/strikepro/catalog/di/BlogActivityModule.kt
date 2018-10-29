package com.strikepro.catalog.di

import com.strikepro.catalog.BlogActivity
import com.strikepro.catalog.di.builder.BlogActivityFragmentBuildersModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class BlogActivityModule {

    @ContributesAndroidInjector(modules = [BlogActivityFragmentBuildersModule::class])
    abstract fun contributeBlogActivity(): BlogActivity

}