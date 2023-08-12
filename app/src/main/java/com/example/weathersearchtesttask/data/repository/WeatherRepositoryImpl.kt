package com.example.weathersearchtesttask.data.repository

import com.example.weathersearchtesttask.data.dto.DataWeatherDto
import com.example.weathersearchtesttask.data.remote.ApiService
import com.example.weathersearchtesttask.domain.repository.WeatherRepository
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 12.08.2023
 */


class WeatherRepositoryImpl @Inject constructor(
    private val api: ApiService
) : WeatherRepository {

   override suspend fun getSearchList(query: String): DataWeatherDto {
      return api.getSearchWeather(query)
   }
}