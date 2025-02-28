package com.ml34.aroundegypt.data.repository.recommended.dataSourceImpl

import com.ml34.aroundegypt.data.api.IExperienceApis
import com.ml34.aroundegypt.data.model.ListExperienceModel
import com.ml34.aroundegypt.data.repository.recent.dataSource.RecentRemoteDataSource
import com.ml34.aroundegypt.data.repository.recommended.dataSource.RecommendedRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RecommendedRemoteDataSourceImpl @Inject constructor(
    private val iApis: IExperienceApis
) : RecommendedRemoteDataSource {
    override suspend fun getRecommended(): Response<ListExperienceModel> {
        return iApis.getRecommended()
    }
}

