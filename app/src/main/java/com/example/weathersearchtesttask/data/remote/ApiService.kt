package com.example.weathersearchtesttask.data.remote

import com.example.weathersearchtesttask.BuildConfig
import com.example.weathersearchtesttask.core.common.Constants.END_POINT_5_DAY
import com.example.weathersearchtesttask.core.common.Constants.END_POINT_WEATHER_5_DAY
import com.example.weathersearchtesttask.data.dto.DataWeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author : Mingaleev D
 * @data : 12.08.2023
 */


interface ApiService {

   @GET(END_POINT_WEATHER_5_DAY)
   suspend fun getSearchWeather(
       @Query("q") query: String,
       @Query("days") days: Int = END_POINT_5_DAY,
       @Query("key") key: String = BuildConfig.API_KEY,
   ): DataWeatherDto
}