package com.example.movies2021

import android.app.Application
import com.example.movies2021.di.components.AppComponent
import com.example.movies2021.di.components.DaggerAppComponent

class App : Application() {
    lateinit var component: AppComponent
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.create()
    }

    fun getAppComponent(): AppComponent {
        return component
    }
}
