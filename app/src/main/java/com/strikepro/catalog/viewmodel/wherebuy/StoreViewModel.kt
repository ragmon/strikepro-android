package com.strikepro.catalog.viewmodel.wherebuy

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.strikepro.catalog.model.wherebuy.Store

class StoreViewModel: ViewModel() {
    private lateinit var stores: MutableLiveData<List<Store>>

    fun getStores(): LiveData<List<Store>> {
        if (!::stores.isInitialized) {
            stores = MutableLiveData()
            loadStores()
        }
        return stores
    }

    private fun loadStores() {
        // Do an asynchronous operation to fetch stores
    }
}