package com.example.cardinfo.di

import com.example.cardinfo.domain.api.SearchInteractor
import com.example.cardinfo.domain.impl.SearchInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    factory<SearchInteractor> {
        SearchInteractorImpl(get())
    }

}