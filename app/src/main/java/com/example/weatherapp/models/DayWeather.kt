package com.example.weatherapp.models

data class DayWeather(
    val applicable_date: String,
    val the_temp: Double,
    val air_pressure: Double,
    val weather_state_abbr: String
) {
}

data class ConsolidatedWeather(val consolidated_weather: List<DayWeather>)