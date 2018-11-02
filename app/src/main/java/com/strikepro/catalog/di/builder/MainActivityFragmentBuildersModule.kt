package com.strikepro.catalog.di.builder

import com.strikepro.catalog.ui.main.FeedFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainActivityFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeFeedFragment(): FeedFragment

}