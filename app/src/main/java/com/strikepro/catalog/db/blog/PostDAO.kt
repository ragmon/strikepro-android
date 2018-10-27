package com.strikepro.catalog.db.blog

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import com.strikepro.catalog.vo.blog.Post

@Dao
abstract class PostDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg posts: Post)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(posts: List<Post>)

    @Query("SELECT * FROM post WHERE id = :id LIMIT 1")
    abstract fun loadByID(id: Int): LiveData<Post>

    @Query("SELECT * FROM post")
    abstract fun loadList(): LiveData<List<Post>>

    @Query("SELECT * FROM post")
    abstract fun loadPaging(): DataSource.Factory<Int, Post>

}