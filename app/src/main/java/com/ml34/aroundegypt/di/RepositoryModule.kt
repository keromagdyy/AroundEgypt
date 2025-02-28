package com.ml34.aroundegypt.di

import com.ml34.aroundegypt.data.repository.recent.RecentRepositoryImpl
import com.ml34.aroundegypt.data.repository.recent.dataSource.RecentLocalDataSource
import com.ml34.aroundegypt.data.repository.recent.dataSource.RecentRemoteDataSource
import com.ml34.aroundegypt.data.repository.recommended.RecommendedRepositoryImpl
import com.ml34.aroundegypt.data.repository.recommended.dataSource.RecommendedLocalDataSource
import com.ml34.aroundegypt.data.repository.recommended.dataSource.RecommendedRemoteDataSource
import com.ml34.aroundegypt.domain.repository.RecentRepository
import com.ml34.aroundegypt.domain.repository.RecommendedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRecentRepository(
        recentLocalDataSource: RecentLocalDataSource,
        recentRemoteDataSource: RecentRemoteDataSource,
    ): RecentRepository {

        return RecentRepositoryImpl(
            recentLocalDataSource,
            recentRemoteDataSource,
        )
    }

    @Provides
    @Singleton
    fun provideRecommendedRepository(
        recommendedLocalDataSource: RecommendedLocalDataSource,
        recommendedRemoteDataSource: RecommendedRemoteDataSource,
    ): RecommendedRepository {

        return RecommendedRepositoryImpl(
            recommendedLocalDataSource,
            recommendedRemoteDataSource,
        )
    }

}