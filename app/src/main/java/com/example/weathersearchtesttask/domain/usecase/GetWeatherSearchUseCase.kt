package com.example.weathersearchtesttask.domain.usecase

import com.example.weathersearchtesttask.core.common.Resource
import com.example.weathersearchtesttask.domain.model.WeatherModel
import com.example.weathersearchtesttask.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 12.08.2023
 */


class GetWeatherSearchUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
   operator fun invoke(query: String): Flow<Resource<List<WeatherModel>>> = flow {
      try {
         emit(Resource.Loading())
         val response = repository.getSearchList(query)
         val list = if (response.forecast.forecastday.isNullOrEmpty()) emptyList<WeatherModel>()
         else response.forecast.forecastday.map { it.toDomain() }
         emit(Resource.Success(list))

      } catch (e: HttpException) {
         emit(Resource.Error(message = e.localizedMessage ?: "Unknown error"))
      } catch (e: IOException) {
         emit(Resource.Error(message = e.localizedMessage ?: "No internet"))
      }
   }
}