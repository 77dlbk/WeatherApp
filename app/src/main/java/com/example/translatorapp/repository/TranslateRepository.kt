package com.example.translatorapp.repository

import com.example.translatorapp.model.models.TranslateResponse
import com.example.translatorapp.model.service.TranslateService
import javax.inject.Inject

class TranslateRepository @Inject constructor(
    private val apiService: TranslateService
){


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