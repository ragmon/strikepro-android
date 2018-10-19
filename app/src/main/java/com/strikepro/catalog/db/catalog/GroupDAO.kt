package com.strikepro.catalog.db.catalog

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import com.strikepro.catalog.vo.catalog.Group

@Dao
abstract class GroupDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg groups: Group)

    @Query("SELECT * FROM `group` WHERE id = :id LIMIT 1")
    abstract fun loadByID(id: Int): LiveData<Group>

    @Query("SELECT * FROM `group`")
    abstract fun loadPaging(): DataSource.Factory<Int, Group>

}