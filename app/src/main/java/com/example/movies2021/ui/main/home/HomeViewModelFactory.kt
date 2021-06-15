package com.example.movies2021.ui.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies2021.data.repository.ResultsRepository
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val resultsRepository: ResultsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(resultsRepository) as T
        }
        throw IllegalArgumentException("Unknown class name need ${HomeViewModel::class.java.simpleName} instance")
    }

}