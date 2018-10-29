package com.strikepro.catalog.di

import com.strikepro.catalog.AboutActivity
import com.strikepro.catalog.di.builder.AboutActivityFragmentBuildersModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class AboutActivityModule {

    @ContributesAndroidInjector(modules = [AboutActivityFragmentBuildersModule::class])
    abstract fun contributeAboutActivity(): AboutActivity

}