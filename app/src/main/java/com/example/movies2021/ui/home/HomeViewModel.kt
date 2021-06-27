package com.example.movies2021.ui.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movies2021.data.repository.ResultsRepository
import com.example.movies2021.utils.Resource
import com.example.movies2021.utils.ResourceState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val resultsRepository: ResultsRepository,
) : ViewModel() {

    fun getResults() = liveData(Dispatchers.IO) {
        emit(Resource(state = LOADING, data = null))
        try {
            val result = resultsRepository.getResults()
            emit(Resource(SUCCESS, data = result))
        } catch (e: Exception) {
            emit(
                Resource(
                    state = ERROR,
                    data = null,
                    message = e.message ?: "unknown error"
                )
            )
        } catch (e: HttpException) {
            emit(
                Resource(
                    state = ERROR,
                    data = null,
                    message = e.message ?: "unknown error"
                )
            )

        } catch (e: IOException) {
            emit(
                Resource(
                    state = ERROR,
                    data = null,
                    message = e.message ?: "unknown error"
                )
            )

        }
    }


}


