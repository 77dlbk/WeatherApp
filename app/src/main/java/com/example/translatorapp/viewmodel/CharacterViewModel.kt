package com.example.translatorapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translatorapp.model.core.Either
import com.example.translatorapp.model.models.CharacterResponse
import com.example.translatorapp.repository.CharacterRepository
import com.example.weatherapp.databinding.FragmentItemBinding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel@Inject constructor(
    private val repository: CharacterRepository
): ViewModel() {

    private val _characters =MutableLiveData<CharacterResponse>()
    val character: MutableLiveData<CharacterResponse> get() = _characters

    private val _error = MutableLiveData<String>()
    val error:MutableLiveData<String> get() = _error

    fun getCharacter(){
        viewModelScope.launch {
            when(val result = repository.getCharacters()){
                is Either.Success -> _characters.value = result.data
                is Either.Error -> _error.value = result.error.toString()
            }
        }
    }
}