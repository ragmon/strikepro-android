package com.strikepro.catalog

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.strikepro.catalog.model.wherebuy.City
import com.strikepro.catalog.model.wherebuy.Store
import com.strikepro.catalog.viewmodel.wherebuy.CityViewModel
import com.strikepro.catalog.viewmodel.wherebuy.StoreViewModel
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import kotlinx.android.synthetic.main.activity_where_buy.*

class WhereBuyActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var cityViewModel: CityViewModel
    private lateinit var storeViewModel: StoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.setApiKey(YANDEX_MAP_API_KEY)
        MapKitFactory.initialize(this)

        setContentView(R.layout.activity_where_buy)

        map_view.map.move(
                CameraPosition(Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
                Animation(Animation.Type.SMOOTH, 0f),
                null
        )

        map_city.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item)
        map_city.onItemSelectedListener = this

        cityViewModel = ViewModelProviders.of(this).get(CityViewModel::class.java)
        storeViewModel = ViewModelProviders.of(this).get(StoreViewModel::class.java)

        cityViewModel.getCities().observe(this, cityObserver)
        cityViewModel.getSelectedCity().observe(this, selectedCityObserver)
        storeViewModel.getStores().observe(this, storeObserver)
    }

    private val cityObserver = Observer<List<City>> { cities ->
        Log.d(TAG, "Cities count = ${cities?.size}")
        cities?.forEachIndexed { index, city ->
            // TODO: fix render logic
            (map_city.adapter as ArrayAdapter<String>).insert(city.name, index)
        }
    }

    private val selectedCityObserver = Observer<City> { city ->
        Log.d(TAG, "Selected city $city")
        //
    }

    private val storeObserver = Observer<List<Store>> { stores ->
        Log.d(TAG, "Stores count = ${stores?.size}")
        stores?.forEach { store ->
            // TODO: release render logic
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Log.d(TAG, "onNothingSelected")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.d(TAG, "onItemSelected; position=$position; id=$id")
    }

    override fun onStart() {
        super.onStart()

        startYandexMap()
    }

    override fun onStop() {
        super.onStop()

        stopYandexMap()
    }

    private fun startYandexMap() {
        map_view.onStart()
        MapKitFactory.getInstance().onStart()
    }

    private fun stopYandexMap() {
        map_view.onStop()
        MapKitFactory.getInstance().onStop()
    }

    companion object {
        const val TAG = "WhereBuyActivity"
        const val YANDEX_MAP_API_KEY = "cfd174d4-56fa-453c-8447-9a7bed58f232"
    }
}
