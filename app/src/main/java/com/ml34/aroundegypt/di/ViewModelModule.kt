package com.ml34.aroundegypt.di

import android.app.Application
import com.ml34.aroundegypt.domain.useCase.recent.GetRecentFromDbUseCase
import com.ml34.aroundegypt.domain.useCase.recent.GetRecentUseCase
import com.ml34.aroundegypt.domain.useCase.recent.SaveRecentUseCase
import com.ml34.aroundegypt.domain.useCase.recommended.GetRecommendedFromDbUseCase
import com.ml34.aroundegypt.domain.useCase.recommended.GetRecommendedUseCase
import com.ml34.aroundegypt.domain.useCase.recommended.SaveRecommendedUseCase
import com.ml34.aroundegypt.presentation.ui.home.mostRecentExperiences.RecentViewModel
import com.ml34.aroundegypt.presentation.ui.home.recommendedExperiences.RecommendedViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ViewModelModule {

    @Provides
    fun provideRecentViewModel(
        app: Application,
        recentUseCase: GetRecentUseCase,
        recentFromDbUseCase: GetRecentFromDbUseCase,
        saveRecentUseCase: SaveRecentUseCase,
    ): RecentViewModel {
        return RecentViewModel(
            app,
            recentUseCase,
            recentFromDbUseCase,
            saveRecentUseCase,
        )
    }

    @Provides
    fun provideRecommendedViewModel(
        app: Application,
        recommendedUseCase: GetRecommendedUseCase,
        recommendedFromDbUseCase: GetRecommendedFromDbUseCase,
        saveRecommendedUseCase: SaveRecommendedUseCase,
    ): RecommendedViewModel {
        return RecommendedViewModel(
            app,
            recommendedUseCase,
            recommendedFromDbUseCase,
            saveRecommendedUseCase,
        )
    }

}