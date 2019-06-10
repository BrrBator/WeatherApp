package com.example.weatherapp.interfaces

import com.example.weatherapp.models.DayWeather

interface ServiceListener {
    fun onFinished(noticeArrayList: ArrayList<DayWeather>)
    fun onFailure()
}