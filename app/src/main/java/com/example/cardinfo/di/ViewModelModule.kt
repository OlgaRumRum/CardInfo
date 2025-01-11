package com.example.cardinfo.di

import com.example.cardinfo.ui.cardHistory.CardHistoryViewModel
import com.example.cardinfo.ui.cardSearch.CardSearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CardSearchViewModel(get(), get())
    }

    viewModel {
        CardHistoryViewModel(get())
    }
}