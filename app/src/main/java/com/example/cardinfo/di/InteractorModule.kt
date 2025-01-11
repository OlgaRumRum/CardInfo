package com.example.cardinfo.di

import com.example.cardinfo.domain.api.DatabaseInteractor
import com.example.cardinfo.domain.api.SearchInteractor
import com.example.cardinfo.domain.impl.DatabaseInteractorImpl
import com.example.cardinfo.domain.impl.SearchInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    factory<SearchInteractor> {
        SearchInteractorImpl(get())
    }

    factory<DatabaseInteractor> {
        DatabaseInteractorImpl(get())
    }

}