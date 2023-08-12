package com.example.weathersearchtesttask.ui.view.adapters.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.weathersearchtesttask.R


/**
 * @author : Mingaleev D
 * @data : 12.08.2023
 */

fun ImageView.load(url: String){
   Glide.with(context)
       .load(url)
       .centerCrop()
       .placeholder(R.drawable.baseline_error_24)
       .into(this)
}