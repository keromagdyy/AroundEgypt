package com.ml34.aroundegypt.di

import android.app.Application
import androidx.room.Room
import com.ml34.aroundegypt.data.db.room.Database
import com.ml34.aroundegypt.data.db.room.dao.RecentDao
import com.ml34.aroundegypt.data.db.room.dao.RecommendedDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideAroundEgyptDatabase(app: Application): Database {
        return Room.databaseBuilder(app, Database::class.java, "around_egypt_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideRecentDao(database: Database): RecentDao {
        return database.getRecentDao()
    }

    @Singleton
    @Provides
    fun provideRecommendedDao(database: Database): RecommendedDao {
        return database.getRecommendedDao()
    }

}