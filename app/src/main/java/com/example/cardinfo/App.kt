package com.example.cardinfo

import android.app.Application
import com.example.cardinfo.di.dataModule
import com.example.cardinfo.di.interactorModule
import com.example.cardinfo.di.repositoryModule
import com.example.cardinfo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(dataModule, interactorModule, repositoryModule, viewModelModule)
        }

    }
}