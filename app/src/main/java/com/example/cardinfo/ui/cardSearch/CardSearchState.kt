package com.example.cardinfo.ui.cardSearch

import com.example.cardinfo.domain.model.CardInfo

sealed class CardSearchState(
    val data: CardInfo?,
) {
    data object Loading : CardSearchState(null)
    data class Content(val content: CardInfo) : CardSearchState(content)
    data class Error(val message: String) : CardSearchState(null)
}
