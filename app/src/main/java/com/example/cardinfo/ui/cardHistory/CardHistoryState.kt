package com.example.binapp.ui.history

sealed interface CardHistoryState {
    data object Content : CardHistoryState
    data object Empty : CardHistoryState
}