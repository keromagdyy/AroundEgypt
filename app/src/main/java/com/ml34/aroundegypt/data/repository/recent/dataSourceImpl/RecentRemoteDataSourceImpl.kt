package com.ml34.aroundegypt.data.repository.recent.dataSourceImpl

import com.ml34.aroundegypt.data.api.IExperienceApis
import com.ml34.aroundegypt.data.model.ListExperienceModel
import com.ml34.aroundegypt.data.repository.recent.dataSource.RecentRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RecentRemoteDataSourceImpl @Inject constructor(
    private val iApis: IExperienceApis
) : RecentRemoteDataSource {
    override suspend fun getRecent(): Response<ListExperienceModel> {
        return iApis.getMostRecent()
    }
}

