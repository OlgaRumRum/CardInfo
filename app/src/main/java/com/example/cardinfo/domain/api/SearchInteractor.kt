package com.example.cardinfo.domain.api

import com.example.cardinfo.domain.model.CardInfo
import com.example.cardinfo.domain.model.Resource

interface SearchInteractor {
    suspend fun getCardInfo(number: String): Resource<CardInfo>
}