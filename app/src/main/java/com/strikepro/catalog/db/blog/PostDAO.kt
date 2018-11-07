package com.strikepro.catalog.db.blog

//import android.arch.paging.DataSource
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

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

//    @Query("SELECT * FROM post")
//    abstract fun loadPaging(): DataSource.Factory<Int, Post>

}