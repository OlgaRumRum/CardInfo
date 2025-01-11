package com.example.cardinfo.domain.impl

import com.example.cardinfo.domain.api.DatabaseInteractor
import com.example.cardinfo.domain.api.DatabaseRepository
import com.example.cardinfo.domain.model.CardInfo
import kotlinx.coroutines.flow.Flow

class DatabaseInteractorImpl(
    private val repository: DatabaseRepository
) : DatabaseInteractor {
    override suspend fun insert(cardInfo: CardInfo) {
        repository.insert(cardInfo)
    }

    override suspend fun delete(cardInfo: CardInfo) {
        repository.delete(cardInfo)
    }

    override fun getAll(): Flow<List<CardInfo>> {
        return repository.getAll()
    }
}