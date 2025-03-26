package com.example.translatorapp.model.service

import android.view.inputmethod.CorrectionInfo
import com.example.translatorapp.model.models.TranslateResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslateService {

    @GET("translations")
    suspend fun translations (
        @Query ("query") query: String,
        @Query ("src") src: String,
        @Query ("dst") dst: String,
        @Query ("guess_direction") guessDirection: String = "false",
        @Query ("follow_corrections") followCorrectionInfo: String = "always"
    ):List<TranslateResponse>
}