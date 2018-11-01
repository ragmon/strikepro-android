package com.strikepro.catalog.db.blog

import android.arch.lifecycle.LiveData

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import com.strikepro.catalog.vo.blog.Category

@Dao
abstract class CategoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg categories: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(categories: List<Category>)

    @Query("SELECT * FROM category WHERE id = :id LIMIT 1")
    abstract fun loadByID(id: Int): LiveData<Category>

    @Query("SELECT * FROM category")
    abstract fun loadAll(): LiveData<List<Category>>

}