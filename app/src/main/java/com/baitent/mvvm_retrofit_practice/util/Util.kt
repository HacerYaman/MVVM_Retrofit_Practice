package com.baitent.mvvm_retrofit_practice.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.baitent.mvvm_retrofit_practice.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


//EXTENSION FUNCTION
fun ImageView.downloadImageFromUrl(url: String?) {

    val options = RequestOptions()
        .placeholder(placeholderProgressBar(context))
        .error(R.mipmap.ic_launcher_round)

    Glide.with(context).setDefaultRequestOptions(options).load(url).into(this)


}

fun placeholderProgressBar(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 48f
        start()
    }
}