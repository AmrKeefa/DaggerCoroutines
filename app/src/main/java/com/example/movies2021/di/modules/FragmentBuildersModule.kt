package com.example.movies2021.di.modules

import com.example.movies2021.ui.main.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
//we make that module to tell dagger that fragment would be a potential client for the app component
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment() : HomeFragment
}
