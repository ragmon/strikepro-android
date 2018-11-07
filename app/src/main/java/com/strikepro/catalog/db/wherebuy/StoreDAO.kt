package com.strikepro.catalog.db.wherebuy

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

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