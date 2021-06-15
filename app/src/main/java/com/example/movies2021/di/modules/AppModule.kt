package com.example.movies2021.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideApplication () : Application{
        return Application()
    }
}