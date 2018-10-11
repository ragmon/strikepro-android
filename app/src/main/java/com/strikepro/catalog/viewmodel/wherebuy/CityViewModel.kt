package com.strikepro.catalog.viewmodel.wherebuy

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.strikepro.catalog.model.wherebuy.City

class CityViewModel: ViewModel() {
    private lateinit var cities: MutableLiveData<List<City>>

    fun getCities(): LiveData<List<City>> {
        if (!::cities.isInitialized) {
            cities = MutableLiveData()
            loadCities()
        }
        return cities
    }

    private fun loadCities() {
        // Do an asynchronous operation to fetch cities
    }
}