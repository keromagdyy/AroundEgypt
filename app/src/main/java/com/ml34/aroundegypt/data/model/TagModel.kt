package com.ml34.aroundegypt.data.model

import com.google.gson.annotations.SerializedName

data class TagModel(
    val id: String = "",
    val name: String = "",
    val disable: String = "",
    @SerializedName("top_pick")
    val topPick: String = "",
)
