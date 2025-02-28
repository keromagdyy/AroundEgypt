package com.ml34.aroundegypt.domain.useCase.recommended

import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.domain.repository.RecommendedRepository
import javax.inject.Inject

class GetRecommendedFromDbUseCase @Inject constructor(private val recommendedRepository: RecommendedRepository) {
    suspend fun execute():List<ExperienceModel> {
        return recommendedRepository.getAllRecommendedFromDB()
    }
}

