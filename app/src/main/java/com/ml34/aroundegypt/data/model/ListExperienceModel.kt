package com.ml34.aroundegypt.data.model

data class ListExperienceModel(
    val meta: MetaModel = MetaModel(),
    val data: List<ExperienceModel> = listOf(),
)
