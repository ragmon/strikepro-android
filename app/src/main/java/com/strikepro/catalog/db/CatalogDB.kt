package com.strikepro.catalog.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import com.strikepro.catalog.db.blog.CategoryDAO
import com.strikepro.catalog.db.blog.PostDAO
import com.strikepro.catalog.db.catalog.ArticleDAO
import com.strikepro.catalog.db.catalog.GroupDAO
import com.strikepro.catalog.db.converter.ResourceTypeConverter
import com.strikepro.catalog.db.feed.FeedCategoryDAO
import com.strikepro.catalog.db.feed.FeedDAO
import com.strikepro.catalog.db.wherebuy.CityDAO
import com.strikepro.catalog.db.wherebuy.StoreDAO

import com.strikepro.catalog.vo.blog.Category
import com.strikepro.catalog.vo.blog.Post
import com.strikepro.catalog.vo.catalog.Article
import com.strikepro.catalog.vo.catalog.Group
import com.strikepro.catalog.vo.main.FeedCategory
import com.strikepro.catalog.vo.main.FeedItem
import com.strikepro.catalog.vo.wherebuy.City
import com.strikepro.catalog.vo.wherebuy.Store

/**
 * Main database description.
 */
@Database(
        entities = [
            // Feed
            FeedCategory::class,
            FeedItem::class,
            // Blog
            Category::class,
            Post::class,
            // Category
            Article::class,
            Group::class,
            // Wherebuy
            City::class,
            Store::class
        ],
        version = 1,
        exportSchema = false
)
@TypeConverters(value = [
    ResourceTypeConverter::class
])
abstract class CatalogDB: RoomDatabase() {

    abstract fun feedCategoryDAO(): FeedCategoryDAO
    abstract fun feedDAO(): FeedDAO

    abstract fun categoryDAO(): CategoryDAO
    abstract fun postDAO(): PostDAO

    abstract fun articleDAO(): ArticleDAO
    abstract fun groupDAO(): GroupDAO

    abstract fun cityDAO(): CityDAO
    abstract fun storeDAO(): StoreDAO

}