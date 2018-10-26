package com.strikepro.catalog.repository

import android.arch.lifecycle.LiveData
import com.strikepro.catalog.api.ApiResponse

import com.strikepro.catalog.api.Resource
import com.strikepro.catalog.common.AppExecutors
import com.strikepro.catalog.db.wherebuy.CityDAO
import com.strikepro.catalog.db.wherebuy.StoreDAO
import com.strikepro.catalog.service.wherebuy.CityService
import com.strikepro.catalog.service.wherebuy.StoreService
import com.strikepro.catalog.vo.wherebuy.City
import com.strikepro.catalog.vo.wherebuy.Store

import javax.inject.Inject

class WherebuyRepository @Inject constructor(
        private val appExecutors: AppExecutors,
        private val cityDAO: CityDAO,
        private val cityService: CityService,
        private val storeDAO: StoreDAO,
        private val storeService: StoreService
) {
    fun loadCityList(): LiveData<Resource<List<City>>> {
        return object : NetworkBoundResource<List<City>, List<City>>(appExecutors) {
            override fun createCall(): LiveData<ApiResponse<List<City>>> = cityService.list()

            override fun loadFromDB(): LiveData<List<City>> = cityDAO.loadAll()

            override fun saveCallResult(item: List<City>) {
                cityDAO.insert(item)
            }

            override fun shouldFetch(data: List<City>?): Boolean = data == null || data.isEmpty()
        }.asLiveData()
    }

    fun loadStoreList(cityID: Int): LiveData<Resource<List<Store>>> {
        return object : NetworkBoundResource<List<Store>, List<Store>>(appExecutors) {
            override fun createCall(): LiveData<ApiResponse<List<Store>>> = storeService.list(cityID)

            override fun loadFromDB(): LiveData<List<Store>> = storeDAO.loadByCity(cityID)

            override fun saveCallResult(item: List<Store>) {
                storeDAO.insert(item)
            }

            override fun shouldFetch(data: List<Store>?): Boolean = data == null || data.isEmpty()
        }.asLiveData()
    }
}