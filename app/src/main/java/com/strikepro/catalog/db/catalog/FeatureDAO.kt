package com.strikepro.catalog.db.catalog

import androidx.lifecycle.LiveData
//import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.strikepro.catalog.vo.catalog.Feature

@Dao
abstract class FeatureDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg features: Feature)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(features: List<Feature>)

    @Query("SELECT * FROM feature WHERE id = :id LIMIT 1")
    abstract fun loadByID(id: Int): LiveData<Feature>

    @Query("SELECT * FROM feature")
    abstract fun loadAll(): LiveData<List<Feature>>

//    @Query("SELECT * FROM article WHERE group_id = :groupID")
//    abstract fun loadPaging(groupID: Int): DataSource.Factory<Int, Article>

}