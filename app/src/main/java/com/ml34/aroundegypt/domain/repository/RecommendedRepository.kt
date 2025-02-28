package com.ml34.aroundegypt.domain.repository

import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.data.model.ListExperienceModel


interface RecommendedRepository {
    suspend fun getRecommended(): ListExperienceModel
    suspend fun getAllRecommendedFromDB():List<ExperienceModel>
    suspend fun saveAllRecommended():List<ExperienceModel>

}
