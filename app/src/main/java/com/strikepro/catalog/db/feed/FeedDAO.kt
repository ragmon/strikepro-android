package com.strikepro.catalog.db.feed

import androidx.lifecycle.LiveData
import androidx.room.*

import com.strikepro.catalog.vo.main.FeedItem

@Dao
abstract class FeedDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg feedItems: FeedItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(feedItems: List<FeedItem>)

    @Query("SELECT * FROM feed_item WHERE id = :id LIMIT 1")
    abstract fun load(id: Int): LiveData<FeedItem>

    @Query("SELECT * FROM feed_item")
    abstract fun loadAll(): LiveData<List<FeedItem>>

}