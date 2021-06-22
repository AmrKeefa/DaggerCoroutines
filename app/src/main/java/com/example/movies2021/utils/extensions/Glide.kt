package com.example.movies2021.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.movies2021.R

fun ImageView.load(url: String) {
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.placeholder)
        .into(this)
}