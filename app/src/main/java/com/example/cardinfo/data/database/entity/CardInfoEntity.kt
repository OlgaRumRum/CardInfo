package com.example.cardinfo.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_info_table")
data class CardInfoEntity(
    @PrimaryKey
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