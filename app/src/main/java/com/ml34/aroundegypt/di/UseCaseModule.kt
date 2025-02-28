package com.ml34.aroundegypt.di

import com.ml34.aroundegypt.domain.repository.RecentRepository
import com.ml34.aroundegypt.domain.repository.RecommendedRepository
import com.ml34.aroundegypt.domain.useCase.recent.GetRecentFromDbUseCase
import com.ml34.aroundegypt.domain.useCase.recent.GetRecentUseCase
import com.ml34.aroundegypt.domain.useCase.recent.SaveRecentUseCase
import com.ml34.aroundegypt.domain.useCase.recommended.GetRecommendedFromDbUseCase
import com.ml34.aroundegypt.domain.useCase.recommended.GetRecommendedUseCase
import com.ml34.aroundegypt.domain.useCase.recommended.SaveRecommendedUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    fun provideGetRecentUseCase(recentRepository: RecentRepository): GetRecentUseCase {
        return GetRecentUseCase(recentRepository)
    }
    @Provides
    fun provideGetRecentFromDbUseCase(recentRepository: RecentRepository): GetRecentFromDbUseCase {
        return GetRecentFromDbUseCase(recentRepository)
    }
    @Provides
    fun provideSaveRecentToDbUseCase(recentRepository: RecentRepository): SaveRecentUseCase {
        return SaveRecentUseCase(recentRepository)
    }



//    @Provides
//    fun provideGetRecommendedUseCase(recommendedRepository: RecommendedRepository): GetRecommendedUseCase {
//        return GetRecommendedUseCase(recommendedRepository)
//    }
//    @Provides
//    fun provideGetRecentFromDbUseCase(recommendedRepository: RecommendedRepository): GetRecommendedFromDbUseCase {
//        return GetRecommendedFromDbUseCase(recommendedRepository)
//    }
//    @Provides
//    fun provideSaveRecentToDbUseCase(recommendedRepository: RecommendedRepository): SaveRecommendedUseCase {
//        return SaveRecommendedUseCase(recommendedRepository)
//    }


}