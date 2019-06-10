package com.example.weatherapp.presenters

import com.example.weatherapp.interfaces.ActivityView
import com.example.weatherapp.interfaces.ServiceListener
import com.example.weatherapp.models.DayWeather
import com.example.weatherapp.models.WeatherServiceConnection

class MainActivityPresenter(val weatherServiceConnection: WeatherServiceConnection, val activityView: ActivityView) :
    ServiceListener {

    fun loadData() {
        weatherServiceConnection.loadData(this)
    }

    override fun onFinished(noticeArrayList: ArrayList<DayWeather>) {
        activityView.showList(noticeArrayList)
    }

    override fun onFailure() {
        activityView.showError()
    }
}