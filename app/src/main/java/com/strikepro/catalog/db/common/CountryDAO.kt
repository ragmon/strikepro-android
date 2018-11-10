package com.strikepro.catalog.db.common

import androidx.lifecycle.LiveData
//import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.strikepro.catalog.vo.Country

@Dao
abstract class CountryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg countries: Country)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(series: List<Country>)

    @Query("SELECT * FROM country WHERE id = :id LIMIT 1")
    abstract fun loadByID(id: Int): LiveData<Country>

    @Query("SELECT * FROM country")
    abstract fun loadAll(): LiveData<List<Country>>

//    @Query("SELECT * FROM article WHERE group_id = :groupID")
//    abstract fun loadPaging(groupID: Int): DataSource.Factory<Int, Article>

}