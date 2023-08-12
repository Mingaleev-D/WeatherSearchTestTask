package com.example.weathersearchtesttask.ui.view.fragments

import com.example.weathersearchtesttask.domain.model.WeatherModel

data class UISearchState(
    val isLoading: Boolean = false,
    val data: List<WeatherModel>? = null,
    val error: String = ""
)
