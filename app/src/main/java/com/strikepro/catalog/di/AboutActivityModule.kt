package com.strikepro.catalog.di

import com.strikepro.catalog.AboutActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class AboutActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeAboutActivity(): AboutActivity

}