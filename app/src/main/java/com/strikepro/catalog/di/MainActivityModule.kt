package com.strikepro.catalog.di

import com.strikepro.catalog.MainActivity
import com.strikepro.catalog.di.builder.MainActivityFragmentBuildersModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [MainActivityFragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

}