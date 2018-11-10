package com.strikepro.catalog.db.catalog

import androidx.lifecycle.LiveData
//import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.strikepro.catalog.vo.catalog.Manufacturer

@Dao
abstract class ManufacturerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg manufacturer: Manufacturer)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(manufacturer: List<Manufacturer>)

    @Query("SELECT * FROM manufacturer WHERE id = :id LIMIT 1")
    abstract fun loadByID(id: Int): LiveData<Manufacturer>

    @Query("SELECT * FROM manufacturer")
    abstract fun loadAll(): LiveData<List<Manufacturer>>

//    @Query("SELECT * FROM article WHERE group_id = :groupID")
//    abstract fun loadPaging(groupID: Int): DataSource.Factory<Int, Article>

}