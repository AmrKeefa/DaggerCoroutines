package com.example.movies2021.utils

sealed class ResourceState {

    object LOADING : ResourceState()
    object SUCCESS : ResourceState()
    object ERROR : ResourceState()
}