package com.example.cardinfo.util

import com.example.cardinfo.data.database.entity.CardInfoEntity
import com.example.cardinfo.domain.model.CardInfo

fun CardInfo.toCardInfoEntity(): CardInfoEntity {
    return CardInfoEntity(
        number = this.number,
        length = this.length,
        luhn = this.luhn,
        scheme = this.scheme,
        type = this.type,
        brand = this.brand,
        prepaid = this.prepaid,
        countryName = this.countryName,
        numeric = this.numeric,
        alpha2 = this.alpha2,
        emoji = this.emoji,
        currency = this.currency,
        latitude = this.latitude,
        longitude = this.longitude,
        bankName = this.bankName,
        url = this.url,
        phone = this.phone,
        city = this.city
    )
}

fun CardInfoEntity.toCardInfo(): CardInfo {
    return CardInfo(
        number = this.number,
        length = this.length,
        luhn = this.luhn,
        scheme = this.scheme,
        type = this.type,
        brand = this.brand,
        prepaid = this.prepaid,
        countryName = this.countryName,
        numeric = this.numeric,
        alpha2 = this.alpha2,
        emoji = this.emoji,
        currency = this.currency,
        latitude = this.latitude,
        longitude = this.longitude,
        bankName = this.bankName,
        url = this.url,
        phone = this.phone,
        city = this.city
    )
}