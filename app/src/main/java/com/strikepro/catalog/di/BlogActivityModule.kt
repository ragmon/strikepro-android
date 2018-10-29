package com.strikepro.catalog.di

import com.strikepro.catalog.BlogActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class BlogActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeBlogActivity(): BlogActivity

}