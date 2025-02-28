package com.ml34.aroundegypt.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.ml34.aroundegypt.data.db.room.converter.MapConverter

@Entity(tableName = "experiences")
@TypeConverters(MapConverter::class)
data class ExperienceModel(
    @PrimaryKey val id: String = "",
    val title: String = "",
    @SerializedName("cover_photo")
    val coverPhoto: String = "",
    val description: String = "",
    @SerializedName("views_no")
    val viewsNo: Int = 0,
    @SerializedName("likes_no")
    val likesNo: Int = 0,
    @SerializedName("has_video")
    val hasVideo: Int = 0,
    @TypeConverters(MapConverter::class)
    @SerializedName("gmap_location")
    val gMapLocation: MapModel = MapModel(),
    @SerializedName("is_liked")
    val isLiked: Boolean = false,
    val recommended: Int = 0,
)
