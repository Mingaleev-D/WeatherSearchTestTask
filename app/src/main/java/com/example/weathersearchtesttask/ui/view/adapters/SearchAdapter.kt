package com.example.weathersearchtesttask.ui.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weathersearchtesttask.core.common.Constants.CELSIUS
import com.example.weathersearchtesttask.core.common.Constants.HUMIDITY
import com.example.weathersearchtesttask.core.common.Constants.KP_H
import com.example.weathersearchtesttask.core.common.Constants.START_POINT_IMAGE
import com.example.weathersearchtesttask.databinding.SearchItemBinding
import com.example.weathersearchtesttask.domain.model.WeatherModel
import com.example.weathersearchtesttask.ui.view.adapters.extension.formatToDesiredFormat
import com.example.weathersearchtesttask.ui.view.adapters.extension.load

/**
 * @author : Mingaleev D
 * @data : 12.08.2023
 */


class SearchAdapter : RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {

   private var list = mutableListOf<WeatherModel>()

   inner class MyViewHolder(val viewHolder: SearchItemBinding) : ViewHolder(viewHolder.root) {
      @SuppressLint("SetTextI18n") fun bindData(weatherItem: WeatherModel) {

         viewHolder.apply {
            imageView.load(START_POINT_IMAGE + weatherItem.conditionIcon)

            conditionText.text = weatherItem.date.formatToDesiredFormat()
            avgtempC.text = weatherItem.avgtempC.toString() + CELSIUS
            windPover.text = weatherItem.maxwindKph.toString() + KP_H
            dropTxt.text = weatherItem.avghumidity.toString() + HUMIDITY
         }
      }
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val binding =
          SearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return MyViewHolder(binding)
   }

   override fun getItemCount(): Int {
      return this.list.size
   }

   override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.bindData(list[position])
   }

   @SuppressLint("NotifyDataSetChanged") fun setContentList(list: MutableList<WeatherModel>) {
      this.list = list
      notifyDataSetChanged()
   }
}