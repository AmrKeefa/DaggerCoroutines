package com.example.movies2021

import android.app.Application
import com.example.movies2021.di.components.AppComponent
import com.example.movies2021.di.components.DaggerAppComponent
import com.example.movies2021.di.modules.AppModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {
//    lateinit var component: AppComponent
//    override fun onCreate() {
//        super.onCreate()
////       buildComponent()
//    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder().application(this).build()
    }

//    private fun buildComponent() {
//        component = DaggerAppComponent.builder()
//            .appModule(AppModule(this))
//            .build()
//        component.inject(this)
//    }
}
