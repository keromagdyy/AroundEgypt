package com.ml34.aroundegypt.domain.useCase.recent

import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.domain.repository.RecentRepository
import javax.inject.Inject

class SaveRecentUseCase @Inject constructor(private val recentRepository: RecentRepository) {
    suspend fun execute(experienceList:List<ExperienceModel>) = recentRepository.saveAllRecent(experienceList)
}