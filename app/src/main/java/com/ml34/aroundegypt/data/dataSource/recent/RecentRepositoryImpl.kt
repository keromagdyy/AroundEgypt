package com.ml34.aroundegypt.data.dataSource.recent

import com.ml34.aroundegypt.data.model.ListExperienceModel
import com.ml34.aroundegypt.domain.repository.RecentRepository

class RecentRepositoryImpl(
    private val recentRemoteDataSource: RecentRemoteDataSource,
) : RecentRepository {

    override suspend fun getRecent(): ListExperienceModel {
        val competitionModel = ListExperienceModel()

        if (recentRemoteDataSource.getRecent().isSuccessful) {
            val body = recentRemoteDataSource.getRecent().body()
            if (body != null) {
                return body
            }
        }
        return competitionModel
    }
}