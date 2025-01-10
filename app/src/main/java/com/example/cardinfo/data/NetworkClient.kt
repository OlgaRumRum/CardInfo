package com.example.cardinfo.data

import com.example.cardinfo.data.network.Response

interface NetworkClient {
    suspend fun doRequest(dto: Any): Response
}