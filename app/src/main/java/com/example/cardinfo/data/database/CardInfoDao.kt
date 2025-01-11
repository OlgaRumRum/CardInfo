package com.example.cardinfo.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cardinfo.data.database.entity.CardInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CardInfoDao {

    @Insert(entity = CardInfoEntity::class, onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cardInfo: CardInfoEntity)

    @Delete
    suspend fun delete(cardInfo: CardInfoEntity)

    @Query("SELECT * FROM card_info_table")
    fun getAll(): Flow<List<CardInfoEntity>>
}