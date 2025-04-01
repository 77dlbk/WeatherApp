package com.example.translatorapp.repository

import android.util.Log
import com.example.translatorapp.model.core.Either
import com.example.translatorapp.model.core.Either.*
import com.example.translatorapp.model.models.CharacterResponse
import com.example.translatorapp.model.service.CharacterService
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterService: CharacterService
) {
    suspend fun getCharacters():Either<Throwable, CharacterResponse> {
        return try {
            val response = characterService.getCharacters()
            Either.Success(response)
        }catch (e: Exception) {
            e.message.let { Log.e("OLOLO", "Error: ${e.message}")}
            Either.Error(e)
        }
    }
}

