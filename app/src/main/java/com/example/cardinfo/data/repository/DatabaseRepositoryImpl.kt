package com.example.cardinfo.data.repository

import com.example.cardinfo.data.database.AppDatabase
import com.example.cardinfo.data.database.entity.CardInfoEntity
import com.example.cardinfo.domain.api.DatabaseRepository
import com.example.cardinfo.domain.model.CardInfo
import com.example.cardinfo.util.toCardInfo
import com.example.cardinfo.util.toCardInfoEntity
import kotlinx.coroutines.flow.flow

class DatabaseRepositoryImpl(
    private val database: AppDatabase
) : DatabaseRepository {
    override suspend fun insert(cardInfo: CardInfo) {
        database.cardInfoDao().insert(cardInfo.toCardInfoEntity())
    }

    override suspend fun delete(cardInfo: CardInfo) {
        database.cardInfoDao().delete(cardInfo.toCardInfoEntity())
    }

    override fun getAll() = flow {
        database.cardInfoDao().getAll().collect { entities ->
            emit(convertFromBinInfoEntity(entities))
        }
    }

    private fun convertFromBinInfoEntity(entities: List<CardInfoEntity>): List<CardInfo> {
        return entities.map { entity -> entity.toCardInfo() }
    }
}