package com.strikepro.catalog.db.catalog

import androidx.lifecycle.LiveData
//import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.strikepro.catalog.vo.catalog.Seasonality

@Dao
abstract class SeasonalityDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg seasonality: Seasonality)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(seasonality: List<Seasonality>)

    @Query("SELECT * FROM seasonality WHERE id = :id LIMIT 1")
    abstract fun loadByID(id: Int): LiveData<Seasonality>

    @Query("SELECT * FROM seasonality")
    abstract fun loadAll(): LiveData<List<Seasonality>>

//    @Query("SELECT * FROM article WHERE group_id = :groupID")
//    abstract fun loadPaging(groupID: Int): DataSource.Factory<Int, Article>

}