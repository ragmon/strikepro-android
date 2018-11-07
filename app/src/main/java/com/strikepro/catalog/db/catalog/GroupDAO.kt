package com.strikepro.catalog.db.catalog

import androidx.lifecycle.LiveData
//import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.strikepro.catalog.vo.catalog.Group

@Dao
abstract class GroupDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg groups: Group)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(groups: List<Group>)

    @Query("SELECT * FROM `group` WHERE id = :id LIMIT 1")
    abstract fun loadByID(id: Int): LiveData<Group>

    @Query("SELECT * FROM `group` WHERE parent_id IS NULL")
    abstract fun loadRootList(): LiveData<List<Group>>

    @Query("SELECT * FROM `group` WHERE parent_id = :parentID")
    abstract fun loadList(parentID: Int): LiveData<List<Group>>

//    @Query("SELECT * FROM `group`")
//    abstract fun loadPaging(): DataSource.Factory<Int, Group>

}