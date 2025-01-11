package com.example.cardinfo.data.repository

import com.example.cardinfo.data.NetworkClient
import com.example.cardinfo.data.network.CardRequest
import com.example.cardinfo.data.network.CardResponse
import com.example.cardinfo.domain.api.SearchRepository
import com.example.cardinfo.domain.model.CardInfo
import com.example.cardinfo.domain.model.Resource

class SearchRepositoryImpl(
    private val networkClient: NetworkClient
) : SearchRepository {
    override suspend fun getCardInfo(number: String): Resource<CardInfo> {
        val response = networkClient.doRequest(CardRequest(number))

        return if (response is CardResponse) {

            val dto = response.result
            Resource.Success(
                CardInfo(
                    number = number,
                    length = dto.number?.length,
                    luhn = dto.number?.luhn,
                    scheme = dto.scheme,
                    type = dto.type,
                    brand = dto.brand,
                    prepaid = dto.prepaid,
                    countryName = dto.country?.name,
                    numeric = dto.country?.numeric,
                    alpha2 = dto.country?.alpha2,
                    emoji = dto.country?.emoji,
                    currency = dto.country?.currency,
                    latitude = dto.country?.latitude,
                    longitude = dto.country?.longitude,
                    bankName = dto.bank?.name,
                    url = dto.bank?.url,
                    phone = dto.bank?.phone,
                    city = dto.bank?.city
                )
            )
        } else {
            Resource.Error(response.resultCode)
        }

    }
}