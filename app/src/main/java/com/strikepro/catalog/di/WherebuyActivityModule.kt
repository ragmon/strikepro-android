package com.strikepro.catalog.di

import com.strikepro.catalog.WherebuyActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class WherebuyActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): WherebuyActivity

}