package com.example.movies2021.utils.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.visible (){
    visibility = View.VISIBLE
}
fun View.showSnackbar (message : String){
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}