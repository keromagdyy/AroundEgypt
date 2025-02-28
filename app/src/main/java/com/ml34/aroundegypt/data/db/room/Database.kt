package com.ml34.aroundegypt.data.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ml34.aroundegypt.data.db.room.converter.MapConverter
import com.ml34.aroundegypt.data.db.room.dao.RecentDao
import com.ml34.aroundegypt.data.db.room.dao.RecommendedDao
import com.ml34.aroundegypt.data.model.ExperienceModel

@Database(
    entities = [ExperienceModel::class],
    version = 5,
    exportSchema = false
)
@TypeConverters(MapConverter::class, MapConverter::class)
abstract class Database : RoomDatabase() {
    abstract fun getRecentDao(): RecentDao
    abstract fun getRecommendedDao(): RecommendedDao
}