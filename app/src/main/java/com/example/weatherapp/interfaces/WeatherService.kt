package com.example.weatherapp.interfaces

import com.example.weatherapp.models.ConsolidatedWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("location/{cityId}")
    fun getDayWeather(@Path("cityId") cityId: String): Call<ConsolidatedWeather>
}