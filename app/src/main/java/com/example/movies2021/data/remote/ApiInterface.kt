package com.example.movies2021.data.remote

import com.example.movies2021.data.models.Result
import com.example.movies2021.data.models.ResultsResponse
import com.example.movies2021.utils.Constants
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET(EndPoints.RESULTS)
  suspend  fun getResults(
        @Query("api_key") apiKey : String = Constants.API_KEY,
    ): ResultsResponse
}