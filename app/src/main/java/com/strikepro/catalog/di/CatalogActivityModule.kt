package com.strikepro.catalog.di

import com.strikepro.catalog.CatalogActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class CatalogActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeCatalogActivity(): CatalogActivity

}