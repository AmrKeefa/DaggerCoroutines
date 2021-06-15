package com.example.movies2021.di.modules

import com.example.movies2021.data.repository.ResultsRepository
import com.example.movies2021.ui.main.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module
class ViewModelFactoryModule {
    @Provides
    @Singleton
    fun getHomeViewModelFactory(
        resultsRepository: ResultsRepository
    ): HomeViewModelFactory = HomeViewModelFactory(resultsRepository )
}