package com.strikepro.catalog.db.feedback

import androidx.lifecycle.LiveData
//import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.strikepro.catalog.vo.Feedback

@Dao
abstract class FeedbackDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg feedback: Feedback)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(feedback: List<Feedback>)

    @Query("SELECT * FROM feedback WHERE id = :id LIMIT 1")
    abstract fun loadByID(id: Int): LiveData<Feedback>

    @Query("SELECT * FROM feedback")
    abstract fun loadAll(): LiveData<List<Feedback>>

//    @Query("SELECT * FROM article WHERE group_id = :groupID")
//    abstract fun loadPaging(groupID: Int): DataSource.Factory<Int, Article>

}