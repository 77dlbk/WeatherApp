package com.example.translatorapp.model.core

import com.example.translatorapp.model.service.CharacterService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import java.security.Provider.Service
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitClient {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY

}
    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }


    @get:Provides
    @Singleton
    @OptIn(ExperimentalSerializationApi::class)
     val retrofitService :Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
     }

    @get:Provides
    @Singleton
    val characterService:CharacterService by lazy {
        retrofitService.create(CharacterService::class.java)
    }
}




