package com.example.weathersearchtesttask.domain.model

data class WeatherModel (
    val date: String,
    val conditionText: String,
    val conditionIcon: String,
    val avgtempC: Double,
    val maxwindKph: Double,
    val avghumidity: Int
)
