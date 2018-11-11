package com.strikepro.catalog.di

import android.app.Application
import androidx.room.Room

import com.strikepro.catalog.common.BASE_URL
import com.strikepro.catalog.common.DATABASE_NAME

import com.strikepro.catalog.db.CatalogDB
import com.strikepro.catalog.db.blog.CategoryDAO
import com.strikepro.catalog.db.blog.PostDAO
import com.strikepro.catalog.db.catalog.*
import com.strikepro.catalog.db.feed.FeedCategoryDAO
import com.strikepro.catalog.db.feed.FeedDAO
import com.strikepro.catalog.db.wherebuy.CityDAO
import com.strikepro.catalog.db.wherebuy.StoreDAO

import com.strikepro.catalog.service.blog.CategoryService
import com.strikepro.catalog.service.blog.PostService
import com.strikepro.catalog.service.catalog.*
import com.strikepro.catalog.service.wherebuy.CityService
import com.strikepro.catalog.service.wherebuy.StoreService

import com.strikepro.catalog.util.LiveDataCallAdapterFactory

import dagger.Module
import dagger.Provides

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideDB(app: Application): CatalogDB = Room
            .databaseBuilder(app, CatalogDB::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    // ### Retrofit Service Providers #############################################################

    @Singleton
    @Provides
    fun provideCategoryService(): CategoryService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(CategoryService::class.java)

    @Singleton
    @Provides
    fun providePostService(): PostService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(PostService::class.java)

    @Singleton
    @Provides
    fun provideArticleService(): ArticleService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(ArticleService::class.java)

    @Singleton
    @Provides
    fun provideGroupService(): GroupService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(GroupService::class.java)

    @Singleton
    @Provides
    fun provideFeatureService(): FeatureService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(FeatureService::class.java)

    @Singleton
    @Provides
    fun provideSeriesService(): SeriesService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(SeriesService::class.java)

    @Singleton
    @Provides
    fun provideSeasonalityService(): SeasonalityService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(SeasonalityService::class.java)

    @Singleton
    @Provides
    fun provideTypeService(): TypeService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(TypeService::class.java)

    @Singleton
    @Provides
    fun provideManufacturerService(): ManufacturerService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(ManufacturerService::class.java)

    @Singleton
    @Provides
    fun provideCityService(): CityService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(CityService::class.java)

    @Singleton
    @Provides
    fun provideStoreService(): StoreService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(StoreService::class.java)

    // ### DAO Providers ##########################################################################

    @Singleton
    @Provides
    fun provideFeedCategoryDAO(db: CatalogDB): FeedCategoryDAO = db.feedCategoryDAO()

    @Singleton
    @Provides
    fun provideFeedDAO(db: CatalogDB): FeedDAO = db.feedDAO()

    @Singleton
    @Provides
    fun provideCategoryDAO(db: CatalogDB): CategoryDAO = db.categoryDAO()

    @Singleton
    @Provides
    fun providePostDAO(db: CatalogDB): PostDAO = db.postDAO()

    @Singleton
    @Provides
    fun provideArticleDAO(db: CatalogDB): ArticleDAO = db.articleDAO()

    @Singleton
    @Provides
    fun provideGroupDAO(db: CatalogDB): GroupDAO = db.groupDAO()

    @Singleton
    @Provides
    fun provideFeatureDAO(db: CatalogDB): FeatureDAO = db.featureDAO()

    @Singleton
    @Provides
    fun provideSeriesDAO(db: CatalogDB): SeriesDAO = db.seriesDAO()

    @Singleton
    @Provides
    fun provideSeasonalityDAO(db: CatalogDB): SeasonalityDAO = db.seasonalityDAO()

    @Singleton
    @Provides
    fun provideTypeDAO(db: CatalogDB): TypeDAO = db.typeDAO()

    @Singleton
    @Provides
    fun provideManufacturerDAO(db: CatalogDB): ManufacturerDAO = db.manufacturerDAO()

    @Singleton
    @Provides
    fun provideCityDAO(db: CatalogDB): CityDAO = db.cityDAO()

    @Singleton
    @Provides
    fun provideStoreDAO(db: CatalogDB): StoreDAO = db.storeDAO()

}