package com.example.weatherapp.models

import com.example.weatherapp.interfaces.ServiceListener
import com.example.weatherapp.interfaces.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherServiceConnection(val weatherService: WeatherService) {

    val warsawId: String = "523920"

    fun loadData(serviceListener: ServiceListener) {
        weatherService.getDayWeather(warsawId).enqueue(object : Callback<ConsolidatedWeather> {
            override fun onFailure(call: Call<ConsolidatedWeather>, t: Throwable) {
                serviceListener.onFailure()
            }

            override fun onResponse(call: Call<ConsolidatedWeather>, response: Response<ConsolidatedWeather>) {
                serviceListener.onFinished(((response.body())?.consolidated_weather as ArrayList<DayWeather>))
            }
        });
    }
}