package com.ml34.aroundegypt.data.db.room.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ml34.aroundegypt.data.model.MapModel

class MapConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromMapToString(area: MapModel?): String? {
        return gson.toJson(area)
    }

    @TypeConverter
    fun fromStringToMap(string: String?): MapModel? {
        return gson.fromJson(string, MapModel::class.java)
    }
}
