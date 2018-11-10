package com.strikepro.catalog.db.catalog

import androidx.lifecycle.LiveData
//import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.strikepro.catalog.vo.catalog.Series

@Dao
abstract class SeriesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg series: Series)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(series: List<Series>)

    @Query("SELECT * FROM series WHERE id = :id LIMIT 1")
    abstract fun loadByID(id: Int): LiveData<Series>

    @Query("SELECT * FROM series")
    abstract fun loadAll(): LiveData<List<Series>>

//    @Query("SELECT * FROM article WHERE group_id = :groupID")
//    abstract fun loadPaging(groupID: Int): DataSource.Factory<Int, Article>

}