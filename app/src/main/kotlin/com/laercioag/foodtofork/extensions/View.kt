package com.laercioag.foodtofork.extensions

import android.view.View
import android.widget.ImageView
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun ImageView.loadImage(string: String) {
    Glide.with(context).load(string).into(this)
}

fun Fragment.setSupportActionBarTitle(@StringRes idRes: Int) =
    (activity as AppCompatActivity).supportActionBar?.setTitle(idRes)
