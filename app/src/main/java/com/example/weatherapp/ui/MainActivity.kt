package com.example.weatherapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.interfaces.ActivityView
import com.example.weatherapp.models.DayWeather
import com.example.weatherapp.presenters.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), ActivityView {

    val firstPresenter: MainActivityPresenter by inject() { parametersOf(this@MainActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListAdapter()
        firstPresenter.loadData()
    }

    fun initListAdapter() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = WeatherAdapter(ArrayList(), context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }

    override fun showList(weatherArrayList: ArrayList<DayWeather>) {
        (recyclerView.adapter as WeatherAdapter).setList(weatherArrayList)
    }

    override fun showError() {
        Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
    }
}
