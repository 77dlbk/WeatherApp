package com.example.weatherapp.model.core

import com.example.weatherapp.model.service.WeatherApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetrofitClient {

    private const val BASE_URL = "https://api.weatherapi.com/v1/"

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
    val retrofitService: WeatherApiService by lazy {
        Retrofit.Builder()
            // Создаём объект Retrofit для отправки запросов
            .baseUrl(BASE_URL)
            // Устанавливаем базовый адрес сервера
            .client(httpClient)
            // Подключаем наш HTTP-клиент с Interceptor для логирования
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            // Добавляем конвертер, который будет преобразовывать JSON-ответы в объекты Kotlin
            .build()
            // Создаём полностью настроенный объект Retrofit
            .create(WeatherApiService::class.java)
        // Говорим Retrofit, какой интерфейс использовать для запросов (описанный в WeatherApiService)
    }
}



