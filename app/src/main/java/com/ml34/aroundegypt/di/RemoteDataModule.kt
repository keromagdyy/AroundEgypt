package com.ml34.aroundegypt.di

import com.ml34.aroundegypt.data.api.IExperienceApis
import com.ml34.aroundegypt.data.repository.recent.dataSource.RecentRemoteDataSource
import com.ml34.aroundegypt.data.repository.recent.dataSourceImpl.RecentRemoteDataSourceImpl
import com.ml34.aroundegypt.data.repository.recommended.dataSource.RecommendedRemoteDataSource
import com.ml34.aroundegypt.data.repository.recommended.dataSourceImpl.RecommendedRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideRecentRemoteDataSource(
        aPIService: IExperienceApis
    ): RecentRemoteDataSource {
        return RecentRemoteDataSourceImpl(aPIService)
    }

    @Singleton
    @Provides
    fun provideRecommendedRemoteDataSource(
        aPIService: IExperienceApis
    ): RecommendedRemoteDataSource {
        return RecommendedRemoteDataSourceImpl(aPIService)
    }
}