package com.example.movies2021.utils

class Resource<out T> constructor(
    val state: ResourceState,
    val data: T? = null,
    val message: String? = null
)