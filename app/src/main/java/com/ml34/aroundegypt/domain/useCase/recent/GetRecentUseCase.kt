package com.ml34.aroundegypt.domain.useCase.recent

import com.ml34.aroundegypt.data.model.ListExperienceModel
import com.ml34.aroundegypt.domain.repository.RecentRepository
import javax.inject.Inject

class GetRecentUseCase @Inject constructor(private val recentRepository: RecentRepository) {

    suspend fun execute(): ListExperienceModel {
        return recentRepository.getRecent()
    }
}

