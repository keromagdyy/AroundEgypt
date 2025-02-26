package com.ml34.aroundegypt.domain.repository

import com.ml34.aroundegypt.data.model.ListExperienceModel


interface RecentRepository {
    suspend fun getRecent(): ListExperienceModel
}
