package com.strikepro.catalog.db.wherebuy

import androidx.lifecycle.LiveData

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.strikepro.catalog.vo.wherebuy.City

@Dao
abstract class CityDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg cities: City)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(cities: List<City>)

    @Query("SELECT * FROM city WHERE id = :id LIMIT 1")
    abstract fun load(id: Int): LiveData<City>

    @Query("SELECT * FROM city")
    abstract fun loadAll(): LiveData<List<City>>

}