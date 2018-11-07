package com.strikepro.catalog.db.catalog

import androidx.lifecycle.LiveData
//import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.strikepro.catalog.vo.catalog.Article

@Dao
abstract class ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg articles: Article)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(articles: List<Article>)

    @Query("SELECT * FROM article WHERE id = :id LIMIT 1")
    abstract fun loadByID(id: Int): LiveData<Article>

    @Query("SELECT * FROM article WHERE group_id = :groupID")
    abstract fun loadList(groupID: Int): LiveData<List<Article>>

//    @Query("SELECT * FROM article WHERE group_id = :groupID")
//    abstract fun loadPaging(groupID: Int): DataSource.Factory<Int, Article>

}