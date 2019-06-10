package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.interfaces.ActivityView
import com.example.weatherapp.interfaces.WeatherService
import com.example.weatherapp.models.WeatherServiceConnection
import com.example.weatherapp.presenters.MainActivityPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }

    val appModule = module {
        single<WeatherService> { retrofit() }
        single<WeatherServiceConnection> { WeatherServiceConnection(get()) }
        factory { (view: ActivityView) -> MainActivityPresenter(get(), view) }
    }

    fun retrofit(): WeatherService {
        return Retrofit.Builder()
            .baseUrl("https://www.metaweather.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WeatherService::class.java)
    }
}