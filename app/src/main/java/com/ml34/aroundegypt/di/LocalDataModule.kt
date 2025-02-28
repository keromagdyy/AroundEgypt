package com.ml34.aroundegypt.di

import com.ml34.aroundegypt.data.db.room.dao.RecentDao
import com.ml34.aroundegypt.data.db.room.dao.RecommendedDao
import com.ml34.aroundegypt.data.repository.recent.dataSource.RecentLocalDataSource
import com.ml34.aroundegypt.data.repository.recent.dataSourceImpl.RecentLocalDataSourceImpl
import com.ml34.aroundegypt.data.repository.recommended.dataSource.RecommendedLocalDataSource
import com.ml34.aroundegypt.data.repository.recommended.dataSourceImpl.RecommendedLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideRecentModelLocalDataSource(recentModelDao: RecentDao): RecentLocalDataSource {
        return RecentLocalDataSourceImpl(recentModelDao)
    }

    @Singleton
    @Provides
    fun provideRecommendedModelLocalDataSource(recommendedModelDao: RecommendedDao): RecommendedLocalDataSource {
        return RecommendedLocalDataSourceImpl(recommendedModelDao)
    }

}