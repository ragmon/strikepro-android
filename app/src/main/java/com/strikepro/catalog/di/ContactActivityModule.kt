package com.strikepro.catalog.di

import com.strikepro.catalog.ContactActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ContactActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeContactActivity(): ContactActivity

}