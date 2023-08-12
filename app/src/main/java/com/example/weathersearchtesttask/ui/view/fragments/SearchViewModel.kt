package com.example.weathersearchtesttask.ui.view.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathersearchtesttask.core.common.Resource
import com.example.weathersearchtesttask.domain.usecase.GetWeatherSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 12.08.2023
 */

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getWeatherSearchUseCase: GetWeatherSearchUseCase
) :ViewModel(){

   private val _mealSearchList = MutableStateFlow<UISearchState>(UISearchState())
   val mealSearchList: StateFlow<UISearchState> = _mealSearchList

   fun getSearchMeals(query: String) {
      getWeatherSearchUseCase(query).onEach {
         when (it) {
            is Resource.Loading -> {
               _mealSearchList.value = UISearchState(isLoading = true)
            }
            is Resource.Success -> {
               _mealSearchList.value = UISearchState(data = it.data)
            }
            is Resource.Error -> {
               _mealSearchList.value = UISearchState(error = it.message ?: "")
            }
         }
      }.launchIn(viewModelScope)
   }
}