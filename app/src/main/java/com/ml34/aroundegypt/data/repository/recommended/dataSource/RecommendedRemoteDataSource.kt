package com.ml34.aroundegypt.data.repository.recommended.dataSource

import com.ml34.aroundegypt.data.model.ListExperienceModel
import retrofit2.Response

interface RecommendedRemoteDataSource {
    suspend fun getRecommended(): Response<ListExperienceModel>
}