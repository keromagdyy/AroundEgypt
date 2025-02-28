package com.ml34.aroundegypt.data.repository.recent.dataSource

import com.ml34.aroundegypt.data.model.ExperienceModel


interface RecentLocalDataSource {

    suspend fun getAllRecentFromDB(): List<ExperienceModel>
    suspend fun saveAllRecentToDB(recent: List<ExperienceModel>)
    suspend fun clearAll()

}