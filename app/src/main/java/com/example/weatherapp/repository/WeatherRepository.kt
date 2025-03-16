package com.example.weatherapp.repository

import com.example.weatherapp.model.core.RetrofitClient
import com.example.weatherapp.model.models.WeatherResponse

class WeatherRepository {

    private val apiKey ="541a223107ce47b2a9a34045251603"

    suspend fun getCurrentWeather(location: String): WeatherResponse =
        RetrofitClient.retrofitService.getCurrentWeather(apiKey, location)

}