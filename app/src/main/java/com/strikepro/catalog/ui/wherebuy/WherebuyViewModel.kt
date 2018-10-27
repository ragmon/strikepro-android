package com.strikepro.catalog.ui.wherebuy

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

import com.strikepro.catalog.api.Resource
import com.strikepro.catalog.repository.WherebuyRepository
import com.strikepro.catalog.util.AbsentLiveData
import com.strikepro.catalog.vo.wherebuy.City
import com.strikepro.catalog.vo.wherebuy.Store

import javax.inject.Inject

class WherebuyViewModel @Inject constructor(
    wherebuyRepository: WherebuyRepository
): ViewModel() {
    private val cities: LiveData<Resource<List<City>>> = wherebuyRepository.loadCityList()
    private val selectedCity: MutableLiveData<City> = MutableLiveData()
    private val stores: LiveData<Resource<List<Store>>> = Transformations
            .switchMap(selectedCity) { selectedCity ->
                if (selectedCity == null)
                    AbsentLiveData.create()
                else
                    wherebuyRepository.loadStoreList(selectedCity.id)
            }

    fun getCities(): LiveData<Resource<List<City>>> = cities

    fun selectCity(city: City) {
        selectedCity.value = city
    }
    fun getSelectedCity(): LiveData<City> = selectedCity

    fun getStores(): LiveData<Resource<List<Store>>> = stores
}