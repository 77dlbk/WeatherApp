package com.example.weatherapp.view

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
//import com.example.weatherapp.presentor.WeatherContract
//import com.example.weatherapp.presentor.WeatherPresenter
import com.example.weatherapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
//    private val presenter: WeatherPresenter by lazy { WeatherPresenter(this) }
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel.getWeather()
        initialize()

    }

    private fun initialize() {
        binding.apply {
            viewModel.weatherResponse.observe(this@MainActivity){ response->
                txtCurrenttemp.text = response.current?.tempC.toString()
            }

        }
    }




}