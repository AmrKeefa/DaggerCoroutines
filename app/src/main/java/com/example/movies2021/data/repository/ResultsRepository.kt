package com.example.movies2021.data.repository

import com.example.movies2021.data.remote.ApiInterface
import javax.inject.Inject

class ResultsRepository @Inject constructor(private val apiInterface: ApiInterface) {

   suspend fun getResults () = apiInterface.getResults()
}