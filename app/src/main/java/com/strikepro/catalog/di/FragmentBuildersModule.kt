package com.strikepro.catalog.di

import com.strikepro.catalog.ui.about.AboutFragment
import com.strikepro.catalog.ui.blog.BlogFragment
import com.strikepro.catalog.ui.blog.PostFragment
import com.strikepro.catalog.ui.contact.ContactFragment
import com.strikepro.catalog.ui.contact.PartnerFragment
import com.strikepro.catalog.ui.contact.StoreFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeBlogFragment(): BlogFragment

    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostFragment

    @ContributesAndroidInjector
    abstract fun contributeContactFragment(): ContactFragment

    @ContributesAndroidInjector
    abstract fun contributePartnerFragment(): PartnerFragment

    @ContributesAndroidInjector
    abstract fun contributeStoreFragment(): StoreFragment

    @ContributesAndroidInjector
    abstract fun contributeAboutFragment(): AboutFragment

}