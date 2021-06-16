package com.example.movies2021.di.modules

import android.app.Application
import com.example.movies2021.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {
    @Singleton
    @Provides
    fun provideApplication () = app
}