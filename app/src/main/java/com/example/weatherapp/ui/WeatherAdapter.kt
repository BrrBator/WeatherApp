package com.example.weatherapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.models.DayWeather
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.day_item.view.*
import java.lang.Math.round

class WeatherAdapter(val items: ArrayList<DayWeather>, val context: Context) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.day_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dateText.text = items.get(position).applicable_date
        holder.temperature.text =
            context.getString(R.string.temperature, (round(items.get(position).the_temp).toString()))
        holder.pressure.text =
            context.getString(R.string.pressure, (round(items.get(position).air_pressure).toString()))
        Picasso.get()
            .load("https://www.metaweather.com/static/img/weather/png/64/${items.get(position).weather_state_abbr}.png")
            .into(holder.image);
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setList(chunks: ArrayList<DayWeather>) {
        items.clear()
        items.addAll(chunks)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dateText = view.dateText
        val temperature = view.temp
        val pressure = view.pressure
        val image = view.image
    }
}



