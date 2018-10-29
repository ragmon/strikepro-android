package com.strikepro.catalog.di

import com.strikepro.catalog.ContactActivity
import com.strikepro.catalog.di.builder.ContactActivityFragmentBuildersModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ContactActivityModule {

    @ContributesAndroidInjector(modules = [ContactActivityFragmentBuildersModule::class])
    abstract fun contributeContactActivity(): ContactActivity

}