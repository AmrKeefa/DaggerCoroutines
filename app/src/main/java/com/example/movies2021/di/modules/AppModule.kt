package com.example.movies2021.di.modules

import android.app.Application
import com.example.movies2021.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
//    @Singleton
//    @Provides
//    fun provideApplication () = app
    companion object{
    lateinit var app : Application
        @Provides
        fun provideApp () = app
    }
}