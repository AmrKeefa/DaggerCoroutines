package com.example.movies2021.data.remote

import com.example.movies2021.data.models.Result
import com.example.movies2021.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET(EndPoints.RESULTS)
  suspend  fun getResults(
        @Query("api_Key") apiKey : String = Constants.API_KEY,
        @Query("page") pageNumber : Int = 1
    ): List<Result>
}