package com.ml34.aroundegypt.domain.useCase.recommended

import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.domain.repository.RecentRepository
import com.ml34.aroundegypt.domain.repository.RecommendedRepository
import javax.inject.Inject

class SaveRecommendedUseCase @Inject constructor(private val recommendedRepository: RecommendedRepository) {
    suspend fun execute():List<ExperienceModel> = recommendedRepository.saveAllRecommended()
}