package com.strikepro.catalog.viewmodel.wherebuy

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.strikepro.catalog.model.wherebuy.City

class CityViewModel: ViewModel() {
    private lateinit var cities: MutableLiveData<List<City>>
    private val selectedCity: MutableLiveData<City> = MutableLiveData()

    fun getCities(): LiveData<List<City>> {
        if (!::cities.isInitialized) {
            cities = MutableLiveData()
            loadCities()
        }
        return cities
    }

    private fun loadCities() {
        // Do an asynchronous operation to fetch cities
        cities.postValue(arrayListOf(
                City(
                        id = 1,
                        name = "Moscow",
                        country_id = 1,
                        lat = 55.751574f,
                        lng = 37.573856f,
                        created_at = "06.04.2017",
                        updated_at = "06.04.2017"
                ),
                City(
                        id = 2,
                        name = "Peter",
                        country_id = 1,
                        lat = 59.939095f,
                        lng = 30.315868f,
                        created_at = "06.04.2017",
                        updated_at = "06.04.2017"
                )
        ))
    }

    fun selectCity(city: City) {
        selectedCity.value = city
    }

    fun getSelectedCity(): LiveData<City> {
        return selectedCity
    }
}