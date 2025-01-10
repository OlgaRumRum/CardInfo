package com.example.cardinfo.domain.model

data class CardInfo(
    val number: String,
    val length: Int?,
    val luhn: Boolean?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val countryName: String?,
    val numeric: String?,
    val alpha2: String?,
    val emoji: String?,
    val currency: String?,
    val latitude: Int?,
    val longitude: Int?,
    val bankName: String?,
    val url: String?,
    val phone: String?,
    val city: String?,
)