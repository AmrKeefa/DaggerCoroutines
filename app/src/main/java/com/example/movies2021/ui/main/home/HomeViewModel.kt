package com.example.movies2021.ui.main.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies2021.data.model.response.ResultsResponse
import com.example.movies2021.data.repository.ResultsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel(private val resultsRepository: ResultsRepository) : ViewModel() {
    private val _results = MutableLiveData<ResultsResponse>()
    val results: LiveData<ResultsResponse> get() = _results

    init {
        getResults()
    }

    fun getResults() = GlobalScope.launch(Dispatchers.IO) {
        resultsRepository.getResults().let { response ->
            if (response.isSuccessful) {
                _results.postValue(response.body())
            } else {
                Log.d("keefa", "getResults: getResults Error : ${response.code()}")
            }
        }
    }
}