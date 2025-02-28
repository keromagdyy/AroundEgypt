package com.ml34.aroundegypt.data.repository.recent

import android.util.Log
import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.data.model.ListExperienceModel
import com.ml34.aroundegypt.data.repository.recent.dataSource.RecentLocalDataSource
import com.ml34.aroundegypt.data.repository.recent.dataSource.RecentRemoteDataSource
import com.ml34.aroundegypt.domain.repository.RecentRepository
import java.lang.Exception
import javax.inject.Inject

class RecentRepositoryImpl @Inject constructor(
    private val recentLocalDataSource: RecentLocalDataSource,
    private val recentRemoteDataSource: RecentRemoteDataSource
) : RecentRepository {

    override suspend fun getRecent(): ListExperienceModel {
        return try {
            val response = recentRemoteDataSource.getRecent()
            if (response.isSuccessful) {
                response.body()?.also { body ->
                    recentLocalDataSource.clearAll()
                    recentLocalDataSource.saveAllRecentToDB(body.data)
                } ?: ListExperienceModel(data = getAllRecentFromDB())
            } else {
                ListExperienceModel(data = getAllRecentFromDB())
            }
        } catch (exception: Exception) {
            Log.e("RecentRepository", "Error fetching recent data", exception)
            ListExperienceModel(data = getAllRecentFromDB())
        }
    }

    override suspend fun getAllRecentFromDB(): List<ExperienceModel> =
        recentLocalDataSource.getAllRecentFromDB()

    override suspend fun saveAllRecent(experiences: List<ExperienceModel>) {
        recentLocalDataSource.clearAll()
        recentLocalDataSource.saveAllRecentToDB(experiences)
    }
}
