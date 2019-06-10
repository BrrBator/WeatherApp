package com.example.weatherapp.interfaces

import com.example.weatherapp.models.DayWeather

interface ActivityView {
    fun showList(weatherArrayList: ArrayList<DayWeather>)
    fun showError()
}