package com.example.translatorapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translatorapp.model.models.TranslateResponse
import com.example.translatorapp.repository.TranslateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TranslateViewModel
    @Inject constructor(
        private val repository: TranslateRepository
    )
: ViewModel() {

    private val _translateResponse = MutableLiveData<List<TranslateResponse>>()
    val translateResponse:MutableLiveData<List<TranslateResponse>> = _translateResponse

    fun translate (query:String, src:String , dst: String){
        viewModelScope.launch {
                try {
                    val response = repository.translate(query, src, dst)
                    _translateResponse.postValue(response)
                }
                catch (e:Exception){
                    println(e)
                }

            }
        }

    }

