package com.ml34.aroundegypt.data.dataSource.recent

import com.ml34.aroundegypt.data.model.ListExperienceModel
import retrofit2.Response

interface RecentRemoteDataSource {
    suspend fun getRecent(): Response<ListExperienceModel>
}