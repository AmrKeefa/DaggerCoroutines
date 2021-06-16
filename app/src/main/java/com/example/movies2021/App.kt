package com.example.movies2021

import android.app.Application
import com.example.movies2021.di.components.AppComponent
import com.example.movies2021.di.components.DaggerAppComponent
import com.example.movies2021.di.modules.AppModule

class App : Application() {
    lateinit var component: AppComponent
    override fun onCreate() {
        super.onCreate()
       buildComponent()
    }

    private fun buildComponent() {
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)
    }
}
