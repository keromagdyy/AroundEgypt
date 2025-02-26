package com.ml34.aroundegypt.data.dataSource.recent

import com.ml34.aroundegypt.data.api.IExperienceApis
import com.ml34.aroundegypt.data.model.ListExperienceModel
import retrofit2.Response

class RecentRemoteDataSourceImpl(
    private val iApis: IExperienceApis
) : RecentRemoteDataSource {
    override suspend fun getRecent(): Response<ListExperienceModel> {
        return iApis.getMostRecent()
    }
}

