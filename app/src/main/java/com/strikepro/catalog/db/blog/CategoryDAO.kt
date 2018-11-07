package com.strikepro.catalog.db.blog

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

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