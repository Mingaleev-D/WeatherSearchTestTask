package com.example.weathersearchtesttask.ui.view.adapters.extension

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


/**
 * @author : Mingaleev D
 * @data : 12.08.2023
 */

fun String.formatToDesiredFormat(): String {
   val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
   val outputFormat = SimpleDateFormat("EEEE dd MMMM yyyy", Locale.getDefault())

   val date = inputFormat.parse(this)
   return outputFormat.format(date ?: Date())
}