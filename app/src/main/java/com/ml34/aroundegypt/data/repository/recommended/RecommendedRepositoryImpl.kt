package com.ml34.aroundegypt.data.repository.recommended

import android.util.Log
import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.data.model.ListExperienceModel
import com.ml34.aroundegypt.data.repository.recent.dataSource.RecentLocalDataSource
import com.ml34.aroundegypt.data.repository.recent.dataSource.RecentRemoteDataSource
import com.ml34.aroundegypt.data.repository.recommended.dataSource.RecommendedLocalDataSource
import com.ml34.aroundegypt.data.repository.recommended.dataSource.RecommendedRemoteDataSource
import com.ml34.aroundegypt.domain.repository.RecentRepository
import com.ml34.aroundegypt.domain.repository.RecommendedRepository
import java.lang.Exception
import javax.inject.Inject

class RecommendedRepositoryImpl @Inject constructor(
    private val recommendedLocalDataSource: RecommendedLocalDataSource,
    private val recommendedRemoteDataSource: RecommendedRemoteDataSource,
) : RecommendedRepository {

    override suspend fun getRecommended(): ListExperienceModel {
        return try {
            val response = recommendedRemoteDataSource.getRecommended()
            if (response.isSuccessful) {
                response.body()?.also { body ->
                    recommendedLocalDataSource.clearAll()
                    recommendedLocalDataSource.saveAllRecommendedToDB(body.data)
                } ?: getRecommendedFromDB()
            } else {
                getRecommendedFromDB()
            }
        } catch (exception: Exception) {
            Log.e("RecommendedRepository", "Error fetching Recommended data", exception)
            getRecommendedFromDB()
        }
    }

    override suspend fun getAllRecommendedFromDB(): List<ExperienceModel> =
        recommendedLocalDataSource.getAllRecommendedFromDB()

    override suspend fun saveAllRecommended(): List<ExperienceModel> {
        val recentData = getRecommended().data
        recommendedLocalDataSource.clearAll()
        recommendedLocalDataSource.saveAllRecommendedToDB(recentData)
        return recentData
    }

    private suspend fun getRecommendedFromDB(): ListExperienceModel =
        ListExperienceModel(data = recommendedLocalDataSource.getAllRecommendedFromDB())
}