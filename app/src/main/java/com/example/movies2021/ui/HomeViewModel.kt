package com.example.movies2021.ui

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies2021.data.models.Result
import com.example.movies2021.data.models.ResultsResponse
import com.example.movies2021.data.repository.ResultsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val resultsRepository: ResultsRepository
    ) : ViewModel() {
    private val _results = MutableLiveData<List<Result>>()
    val results: LiveData<List<Result>> get() = _results
    init {
        viewModelScope.launch {
            val result = resultsRepository.getResults()
            _results.value = result
        }
    }



//    fun getResults() = GlobalScope.launch(Dispatchers.IO) {
//        resultsRepository.getResults().let { response ->
//            if (response.isSuccessful) {
//                _results.postValue(response.body())
//            } else {
//                Log.d("keefa", "getResults: getResults Error : ${response.code()}")
//            }
//        }
//    }
}