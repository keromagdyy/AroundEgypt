package com.ml34.aroundegypt.data.model

data class MetaModel(
    val code: Int = 0,
    val errors: List<ErrorModel> = listOf(),
    val exception: String = "",
)
