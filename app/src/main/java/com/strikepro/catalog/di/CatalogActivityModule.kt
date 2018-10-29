package com.strikepro.catalog.di

import com.strikepro.catalog.CatalogActivity
import com.strikepro.catalog.di.builder.CatalogActivityFragmentBuildersModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class CatalogActivityModule {

    @ContributesAndroidInjector(modules = [CatalogActivityFragmentBuildersModule::class])
    abstract fun contributeCatalogActivity(): CatalogActivity

}