package com.strikepro.catalog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import kotlinx.android.synthetic.main.activity_where_buy.*

class WhereBuyActivity : AppCompatActivity() {

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
    }

    override fun onStart() {
        super.onStart()

        map_view.onStart()
        MapKitFactory.getInstance().onStart()
    }

    override fun onStop() {
        super.onStop()

        map_view.onStop()
        MapKitFactory.getInstance().onStop()
    }

    companion object {
        const val TAG = "WhereBuyActivity"
        const val YANDEX_MAP_API_KEY = "cfd174d4-56fa-453c-8447-9a7bed58f232"
    }
}
