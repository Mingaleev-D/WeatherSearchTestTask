package com.example.weathersearchtesttask.data.dto


import com.example.weathersearchtesttask.domain.model.WeatherModel
import com.google.gson.annotations.SerializedName

data class Forecastday(
//    @SerializedName("astro")
//    val astro: Astro,
    @SerializedName("date")
    val date: String,
//    @SerializedName("date_epoch")
//    val dateEpoch: Int,
    @SerializedName("day")
    val day: Day,
//    @SerializedName("hour")
//    val hour: List<Hour>
) {
   fun toDomain(): WeatherModel {
      return WeatherModel(
          date = this.date,
          conditionText = this.day.condition.text,
          conditionIcon = this.day.condition.icon,
          avgtempC = this.day.avgtempC,
          maxwindKph = this.day.maxwindKph,
          avghumidity = this.day.avghumidity

      )
   }
}