package com.ml34.aroundegypt.data.model

import com.google.gson.annotations.SerializedName

data class ExperienceModel(
    val id: String = "",
    val title: String = "",
    @SerializedName("cover_photo")
    val coverPhoto: String = "",
    val description: String = "",
    @SerializedName("views_no")
    val viewsNo: Int = 0,
    @SerializedName("likes_no")
    val likesNo: Int = 0,
    val recommended: Int = 0,
    @SerializedName("has_video")
    val hasVideo: Int = 0,
    val tags: List<TagModel> = listOf(),
    val city: TagModel = TagModel(),
    @SerializedName("tour_html")
    val tourHtml: String = "",
    @SerializedName("famous_figure")
    val famousFigure: String = "",
    val period: String = "",
    val founded: String = "",
    @SerializedName("detailed_description")
    val detailedDescription: String = "",
    val address: String = "",
    @SerializedName("gmap_location")
    val gMapLocation: MapModel = MapModel(),
    @SerializedName("is_liked")
    val isLiked: Boolean? = null,
    @SerializedName("has_audio")
    val hasAudio: Boolean? = null,
    @SerializedName("audio_url")
    val audioUrl: String = "",
)
