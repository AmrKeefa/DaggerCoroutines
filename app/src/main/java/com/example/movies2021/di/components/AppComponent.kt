package com.example.movies2021.di.components

import com.example.movies2021.App
import com.example.movies2021.MainActivity
import com.example.movies2021.di.modules.ApiModule
import com.example.movies2021.di.modules.AppModule
import com.example.movies2021.di.modules.NetworkModule
import com.example.movies2021.di.modules.ViewModelFactoryModule
import com.example.movies2021.ui.main.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class
        , ApiModule::class
        , NetworkModule::class
        , ViewModelFactoryModule::class]
)
interface AppComponent {

    fun inject(app: App)
    fun inject(homeFragment: HomeFragment)
}