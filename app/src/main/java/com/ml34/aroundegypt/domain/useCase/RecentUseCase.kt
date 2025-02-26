package com.ml34.aroundegypt.domain.useCase

import com.ml34.aroundegypt.data.model.ListExperienceModel
import com.ml34.aroundegypt.domain.repository.RecentRepository

class RecentUseCase(private val recentRepository: RecentRepository) {
    suspend fun execute(): ListExperienceModel {
        return recentRepository.getRecent()
    }
}