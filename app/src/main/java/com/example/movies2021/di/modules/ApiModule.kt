package com.example.movies2021.di.modules

import com.example.movies2021.data.remote.ApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ApiModule {
    @Provides
    @Singleton
    fun providesApiInterface(retrofit: Retrofit): ApiInterface = retrofit.create(
        ApiInterface::class.java
    )

}