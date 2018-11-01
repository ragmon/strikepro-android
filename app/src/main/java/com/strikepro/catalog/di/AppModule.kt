package com.strikepro.catalog.di

import android.app.Application
import android.arch.persistence.room.Room

import com.strikepro.catalog.common.BASE_URL
import com.strikepro.catalog.common.DATABASE_NAME

import com.strikepro.catalog.db.CatalogDB
import com.strikepro.catalog.db.blog.CategoryDAO
import com.strikepro.catalog.db.blog.PostDAO
import com.strikepro.catalog.db.catalog.ArticleDAO
import com.strikepro.catalog.db.catalog.GroupDAO
import com.strikepro.catalog.db.wherebuy.CityDAO
import com.strikepro.catalog.db.wherebuy.StoreDAO

import com.strikepro.catalog.service.blog.CategoryService
import com.strikepro.catalog.service.blog.PostService
import com.strikepro.catalog.service.catalog.ArticleService
import com.strikepro.catalog.service.catalog.GroupService
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
    fun provideDB(app: Application): CatalogDB {
        return Room
                .databaseBuilder(app, CatalogDB::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    // ### Retrofit Service Providers #############################################################

    @Singleton
    @Provides
    fun provideCategoryService(): CategoryService {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(CategoryService::class.java)
    }

    @Singleton
    @Provides
    fun providePostService(): PostService {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(PostService::class.java)
    }

    @Singleton
    @Provides
    fun provideArticleService(): ArticleService {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(ArticleService::class.java)
    }

    @Singleton
    @Provides
    fun provideGroupService(): GroupService {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(GroupService::class.java)
    }

    @Singleton
    @Provides
    fun provideCityService(): CityService {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(CityService::class.java)
    }

    @Singleton
    @Provides
    fun provideStoreService(): StoreService {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(StoreService::class.java)
    }

    // ### DAO Providers ##########################################################################

    @Singleton
    @Provides
    fun provideCategoryDAO(db: CatalogDB): CategoryDAO {
        return db.categoryDAO()
    }

    @Singleton
    @Provides
    fun providePostDAO(db: CatalogDB): PostDAO {
        return db.postDAO()
    }

    @Singleton
    @Provides
    fun provideArticleDAO(db: CatalogDB): ArticleDAO {
        return db.articleDAO()
    }

    @Singleton
    @Provides
    fun provideGroupDAO(db: CatalogDB): GroupDAO {
        return db.groupDAO()
    }

    @Singleton
    @Provides
    fun provideCityDAO(db: CatalogDB): CityDAO {
        return db.cityDAO()
    }

    @Singleton
    @Provides
    fun provideStoreDAO(db: CatalogDB): StoreDAO {
        return db.storeDAO()
    }

}