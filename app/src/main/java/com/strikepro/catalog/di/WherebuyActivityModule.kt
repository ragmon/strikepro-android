package com.strikepro.catalog.di

import com.strikepro.catalog.WherebuyActivity
import com.strikepro.catalog.di.builder.WherebuyActivityFragmentBuildersModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class WherebuyActivityModule {

    @ContributesAndroidInjector(modules = [WherebuyActivityFragmentBuildersModule::class])
    abstract fun contributeWherebuyActivity(): WherebuyActivity

}