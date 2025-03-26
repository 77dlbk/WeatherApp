package com.example.translatorapp.repository

import android.location.GnssAntennaInfo.SphericalCorrections
import com.example.translatorapp.model.core.RetrofitClient
import com.example.translatorapp.model.models.TranslateResponse
import com.example.translatorapp.model.service.TranslateService
import retrofit2.http.Query

class TranslateRepository {
    private val apiService = RetrofitClient.translateService

    suspend fun translate(
        query: String,
        src: String,
        dst: String,

    ):List<TranslateResponse> = apiService.translations(
        query = query,
        src = src,
        dst = dst
    )

}