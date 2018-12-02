package com.strikepro.catalog.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import com.strikepro.catalog.db.blog.CategoryDAO
import com.strikepro.catalog.db.blog.PostDAO
import com.strikepro.catalog.db.catalog.*
import com.strikepro.catalog.db.common.CountryDAO
import com.strikepro.catalog.db.converter.DatetimeTypeConverter
import com.strikepro.catalog.db.converter.ResourceTypeConverter
import com.strikepro.catalog.db.feed.FeedCategoryDAO
import com.strikepro.catalog.db.feed.FeedDAO
import com.strikepro.catalog.db.feedback.FeedbackDAO
import com.strikepro.catalog.db.wherebuy.CityDAO
import com.strikepro.catalog.db.wherebuy.StoreDAO
import com.strikepro.catalog.vo.Country
import com.strikepro.catalog.vo.Feedback

import com.strikepro.catalog.vo.blog.Category
import com.strikepro.catalog.vo.blog.Post
import com.strikepro.catalog.vo.catalog.*
import com.strikepro.catalog.vo.main.FeedCategory
import com.strikepro.catalog.vo.main.FeedItem
import com.strikepro.catalog.vo.wherebuy.City
import com.strikepro.catalog.vo.wherebuy.Store

/**
 * Main database description.
 */
@Database(
        entities = [
            // Common
            Country::class,
            // Feed
            FeedCategory::class,
            FeedItem::class,
            // Blog
            Category::class,
            Post::class,
            // Category
            Article::class,
            Group::class,
            Feature::class,
            Manufacturer::class,
            Seasonality::class,
            Series::class,
            Type::class,
            // Wherebuy
            City::class,
            Store::class,
            // Feedback
            Feedback::class
        ],
        version = 2,
        exportSchema = false
)
@TypeConverters(value = [
    DatetimeTypeConverter::class,
    ResourceTypeConverter::class
])
abstract class CatalogDB: RoomDatabase() {

    // Common
    abstract fun countryDAO(): CountryDAO

    // Main feed
    abstract fun feedCategoryDAO(): FeedCategoryDAO
    abstract fun feedDAO(): FeedDAO

    // Blog
    abstract fun categoryDAO(): CategoryDAO
    abstract fun postDAO(): PostDAO

    // Catalog
    abstract fun articleDAO(): ArticleDAO
    abstract fun groupDAO(): GroupDAO
    abstract fun manufacturerDAO(): ManufacturerDAO
    abstract fun seasonalityDAO(): SeasonalityDAO
    abstract fun seriesDAO(): SeriesDAO
    abstract fun featureDAO(): FeatureDAO
    abstract fun typeDAO(): TypeDAO

    // Wherebuy
    abstract fun cityDAO(): CityDAO
    abstract fun storeDAO(): StoreDAO

    // Feedback
    abstract fun feedbackDAO(): FeedbackDAO

}