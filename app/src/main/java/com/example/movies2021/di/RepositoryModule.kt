package com.example.movies2021.di

import com.example.movies2021.data.remote.ApiInterface
import com.example.movies2021.data.repository.ResultsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideResultRepository (apiInterface: ApiInterface) : ResultsRepository{
        return ResultsRepository(apiInterface)
    }

}