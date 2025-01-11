package com.example.cardinfo.di

import androidx.room.Room
import com.example.cardinfo.data.NetworkClient
import com.example.cardinfo.data.database.AppDatabase
import com.example.cardinfo.data.network.CardApi
import com.example.cardinfo.data.network.RetrofitNetworkClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<CardApi> {
        Retrofit.Builder()
            .baseUrl("https://lookup.binlist.net/")
            .client(createHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CardApi::class.java)
    }

    single<NetworkClient> {
        RetrofitNetworkClient(get(), get())
    }

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "database.db").build()
    }

}

private fun createHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient().newBuilder()
        .addInterceptor(interceptor)
        .build()
}