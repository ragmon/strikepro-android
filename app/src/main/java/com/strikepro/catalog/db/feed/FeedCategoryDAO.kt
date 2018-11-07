package com.strikepro.catalog.db.feed

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.strikepro.catalog.vo.main.FeedCategory

@Dao
abstract class FeedCategoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg feedCategories: FeedCategory)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(feedCategories: List<FeedCategory>)

    @Query("SELECT * FROM feed_category WHERE id = :id LIMIT 1")
    abstract fun load(id: Int): LiveData<FeedCategory>

    @Query("SELECT * FROM feed_category")
    abstract fun loadAll(): LiveData<List<FeedCategory>>
    
}