package com.ml34.aroundegypt.data.api

import com.ml34.aroundegypt.data.model.ListExperienceModel
import com.ml34.aroundegypt.data.util.ConstantLinks
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IExperienceApis {

    @GET(ConstantLinks.EXPERIENCES)
    suspend fun getMostRecent(): Response<ListExperienceModel>

    @GET(ConstantLinks.EXPERIENCES)
    suspend fun getRecommended(
        @Query("filter[recommended]") recommended: Boolean = true
    ): Response<ListExperienceModel>

}