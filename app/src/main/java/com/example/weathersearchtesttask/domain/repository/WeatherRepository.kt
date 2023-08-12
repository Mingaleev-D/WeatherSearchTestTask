package com.example.weathersearchtesttask.domain.repository

import com.example.weathersearchtesttask.data.dto.DataWeatherDto

/**
 * @author : Mingaleev D
 * @data : 12.08.2023
 */


interface WeatherRepository {
   suspend fun getSearchList(query:String): DataWeatherDto
}