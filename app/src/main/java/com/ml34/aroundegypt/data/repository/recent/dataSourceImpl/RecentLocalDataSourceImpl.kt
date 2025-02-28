package com.ml34.aroundegypt.data.repository.recent.dataSourceImpl

import com.ml34.aroundegypt.data.db.room.dao.RecentDao
import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.data.repository.recent.dataSource.RecentLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecentLocalDataSourceImpl(private val recentDao: RecentDao) :
    RecentLocalDataSource {
    override suspend fun getAllRecentFromDB(): List<ExperienceModel> {
        return recentDao.getAllRecent()
    }

    override suspend fun saveAllRecentToDB(recent: List<ExperienceModel>) {
        CoroutineScope(Dispatchers.IO).launch {
            recentDao.saveAllRecent(recent)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            recentDao.deleteAllRecent()
        }
    }
}