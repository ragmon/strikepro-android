package com.strikepro.catalog.db.catalog

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import com.strikepro.catalog.vo.catalog.Article

@Dao
abstract class ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg articles: Article)

    @Query("SELECT * FROM article WHERE id = :id LIMIT 1")
    abstract fun load(id: Int): LiveData<Article>

    @Query("SELECT * FROM article")
    abstract fun loadPaging(): DataSource.Factory<Int, Article>

}