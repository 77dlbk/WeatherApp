package com.example.translatorapp.model.service

import com.example.translatorapp.model.models.CharacterResponse
import retrofit2.http.GET

interface CharacterService {

    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}