package com.example.movies2021.di.components

import android.app.Application
import com.example.movies2021.App
import com.example.movies2021.MainActivity
import com.example.movies2021.di.modules.*
import com.example.movies2021.ui.main.home.HomeFragment
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
//    modules = [AppModule::class
//        , ApiModule::class
//        , NetworkModule::class
//        , ViewModelFactoryModule::class]
modules = [
    AndroidSupportInjectionModule::class,
    FragmentBuildersModule::class,
    AppModule::class
]
)
/*we telling that App will be a client for AppComponent
 or we going to inject App into this component*/
interface AppComponent :AndroidInjector<App>{
//    fun inject(app: App)
//    fun inject(homeFragment: HomeFragment)

    @Component.Builder
    interface Builder {
        fun application (application : Application) : Builder
//
        fun build() : AppComponent
    }
}