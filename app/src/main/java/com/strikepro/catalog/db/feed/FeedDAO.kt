package com.strikepro.catalog.db.feed

import android.arch.lifecycle.LiveData

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

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