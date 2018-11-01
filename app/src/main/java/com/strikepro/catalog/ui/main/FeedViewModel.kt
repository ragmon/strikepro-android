package com.strikepro.catalog.ui.main

import android.arch.lifecycle.ViewModel

import com.strikepro.catalog.repository.FeedRepository

import javax.inject.Inject

class FeedViewModel @Inject constructor(
        private val feedRepository: FeedRepository
): ViewModel() {

}