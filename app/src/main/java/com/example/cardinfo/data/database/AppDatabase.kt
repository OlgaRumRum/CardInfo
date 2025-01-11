package com.example.cardinfo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cardinfo.data.database.entity.CardInfoEntity

@Database(version = 1, entities = [CardInfoEntity::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun cardInfoDao(): CardInfoDao
}