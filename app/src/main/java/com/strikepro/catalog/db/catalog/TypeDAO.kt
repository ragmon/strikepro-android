package com.strikepro.catalog.db.catalog

import androidx.lifecycle.LiveData
//import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.strikepro.catalog.vo.catalog.Type

@Dao
abstract class TypeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg types: Type)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(types: List<Type>)

    @Query("SELECT * FROM type WHERE id = :id LIMIT 1")
    abstract fun loadByID(id: Int): LiveData<Type>

    @Query("SELECT * FROM type")
    abstract fun loadAll(): LiveData<List<Type>>

//    @Query("SELECT * FROM article WHERE group_id = :groupID")
//    abstract fun loadPaging(groupID: Int): DataSource.Factory<Int, Article>

}