package com.example.weathersearchtesttask.data.dto


import com.google.gson.annotations.SerializedName

data class DataWeatherDto(
    @SerializedName("forecast")
    val forecast: Forecast,

)