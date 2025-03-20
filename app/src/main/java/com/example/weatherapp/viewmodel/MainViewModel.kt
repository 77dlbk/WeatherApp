package com.example.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.model.models.WeatherResponse
import com.example.weatherapp.repository.WeatherRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = WeatherRepository()
    private val _weatherResponse = MutableLiveData<WeatherResponse>()
    val weatherResponse: LiveData<WeatherResponse> get() = _weatherResponse

    fun getWeather(){
        viewModelScope.launch {
            try {
                val response= repository.getCurrentWeather("Bishkek")
                _weatherResponse.postValue(response)
            }
            catch (e:Exception){
                println(e)
            }
        }
    }

}