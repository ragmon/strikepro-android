package com.strikepro.catalog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector

import javax.inject.Inject

class AboutActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

}
