package com.strikepro.catalog.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import com.strikepro.catalog.db.blog.CategoryDAO
import com.strikepro.catalog.db.blog.PostDAO
import com.strikepro.catalog.db.catalog.ArticleDAO
import com.strikepro.catalog.db.catalog.GroupDAO
import com.strikepro.catalog.db.wherebuy.CityDAO
import com.strikepro.catalog.db.wherebuy.StoreDAO

import com.strikepro.catalog.vo.blog.Category
import com.strikepro.catalog.vo.blog.Post
import com.strikepro.catalog.vo.catalog.Article
import com.strikepro.catalog.vo.catalog.Group
import com.strikepro.catalog.vo.wherebuy.City
import com.strikepro.catalog.vo.wherebuy.Store

/**
 * Main database description.
 */
@Database(
        entities = [
            Category::class,
            Post::class,
            Article::class,
            Group::class,
            City::class,
            Store::class
        ],
        version = 1,
        exportSchema = false
)
abstract class CatalogDB: RoomDatabase() {

    abstract fun categoryDAO(): CategoryDAO
    abstract fun postDAO(): PostDAO

    abstract fun articleDAO(): ArticleDAO
    abstract fun groupDAO(): GroupDAO

    abstract fun cityDAO(): CityDAO
    abstract fun storeDAO(): StoreDAO

}