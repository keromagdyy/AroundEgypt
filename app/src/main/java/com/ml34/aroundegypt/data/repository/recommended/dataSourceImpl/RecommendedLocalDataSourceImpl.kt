package com.ml34.aroundegypt.data.repository.recommended.dataSourceImpl

import com.ml34.aroundegypt.data.db.room.dao.RecommendedDao
import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.data.repository.recommended.dataSource.RecommendedLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecommendedLocalDataSourceImpl @Inject constructor(private val recentDao: RecommendedDao) :
    RecommendedLocalDataSource {
    override suspend fun getAllRecommendedFromDB(): List<ExperienceModel> {
        return recentDao.getAllRecommended()
    }

    override suspend fun saveAllRecommendedToDB(recommended: List<ExperienceModel>) {
        CoroutineScope(Dispatchers.IO).launch {
            recentDao.saveAllRecommended(recommended)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            recentDao.deleteAllRecommended()
        }
    }
}