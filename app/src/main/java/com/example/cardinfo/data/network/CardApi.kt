package com.example.cardinfo.data.network

import com.example.cardinfo.data.dto.CardInfoDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface CardApi {
    @Headers(
        "Accept-Version: 3"
    )
    @GET("/{bin_number}")
    suspend fun getCardInfo(@Path("bin_number") binNumber: String): CardInfoDto
}