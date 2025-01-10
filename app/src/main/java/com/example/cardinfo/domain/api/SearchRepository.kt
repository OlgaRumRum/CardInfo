package com.example.cardinfo.domain.api

import com.example.cardinfo.domain.model.CardInfo
import com.example.cardinfo.domain.model.Resource

interface SearchRepository {
    suspend fun getBinInfo(number: String): Resource<CardInfo>
}