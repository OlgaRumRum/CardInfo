package com.example.cardinfo.domain.api

import com.example.cardinfo.domain.model.CardInfo
import kotlinx.coroutines.flow.Flow

interface DatabaseInteractor {
    suspend fun insert(cardInfo: CardInfo)

    suspend fun delete(cardInfo: CardInfo)

    fun getAll(): Flow<List<CardInfo>>
}