package com.strikepro.catalog.db.wherebuy

import android.arch.lifecycle.LiveData

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import com.strikepro.catalog.vo.wherebuy.Store

@Dao
abstract class StoreDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg stores: Store)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(stores: List<Store>)

    @Query("SELECT * FROM store WHERE id = :id LIMIT 1")
    abstract fun load(id: Int): LiveData<Store>

    @Query("SELECT * FROM store WHERE city_id = :cityId")
    abstract fun loadByCity(cityId: Int): LiveData<List<Store>>

}