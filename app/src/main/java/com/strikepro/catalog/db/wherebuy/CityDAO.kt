package com.strikepro.catalog.db.wherebuy

import android.arch.lifecycle.LiveData

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import com.strikepro.catalog.vo.wherebuy.City

@Dao
abstract class CityDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg cities: City)

    @Query("SELECT * FROM city WHERE id = :id LIMIT 1")
    abstract fun load(id: Int): LiveData<City>

    @Query("SELECT * FROM city")
    abstract fun loadAll(): LiveData<List<City>>

}