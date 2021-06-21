package com.example.movies2021.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies2021.data.models.Result
import com.example.movies2021.data.models.ResultsResponse
import com.example.movies2021.data.repository.ResultsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Single

import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject
@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val resultsRepository: ResultsRepository
    ) : ViewModel() {
    private val _results = MutableLiveData<ResultsResponse>()
    val results: LiveData<ResultsResponse> get() = _results
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