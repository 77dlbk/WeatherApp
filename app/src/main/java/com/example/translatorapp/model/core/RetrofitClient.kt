package com.example.translatorapp.model.core

import com.example.translatorapp.model.service.TranslateService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import java.security.Provider.Service

object RetrofitClient {

    private const val BASE_URL = "https://linguee-api.fly.dev/api/v2/"

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

     val retrofitService :Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
     }

    val translateService:TranslateService by lazy {
        retrofitService.create(TranslateService::class.java)
    }
}




