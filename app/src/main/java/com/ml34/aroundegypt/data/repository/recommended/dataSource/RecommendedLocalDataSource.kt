package com.ml34.aroundegypt.data.repository.recommended.dataSource

import com.ml34.aroundegypt.data.model.ExperienceModel


interface RecommendedLocalDataSource {

    suspend fun getAllRecommendedFromDB(): List<ExperienceModel>
    suspend fun saveAllRecommendedToDB(recommended: List<ExperienceModel>)
    suspend fun clearAll()

}