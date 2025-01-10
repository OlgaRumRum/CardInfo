package com.example.cardinfo.di

import com.example.cardinfo.data.repository.SearchRepositoryImpl
import com.example.cardinfo.domain.api.SearchRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<SearchRepository> {
        SearchRepositoryImpl(get())
    }
}