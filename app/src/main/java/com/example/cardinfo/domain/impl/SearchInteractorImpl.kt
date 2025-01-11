package com.example.cardinfo.domain.impl

import com.example.cardinfo.domain.api.SearchInteractor
import com.example.cardinfo.domain.api.SearchRepository
import com.example.cardinfo.domain.model.CardInfo
import com.example.cardinfo.domain.model.Resource

class SearchInteractorImpl(
    private val repository: SearchRepository
) : SearchInteractor {
    override suspend fun getCardInfo(number: String): Resource<CardInfo> {
        return repository.getCardInfo(number)
    }
}