package com.baitent.mvvm_retrofit_practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baitent.mvvm_retrofit_practice.R
import com.baitent.mvvm_retrofit_practice.models.Country
import com.baitent.mvvm_retrofit_practice.util.downloadImageFromUrl
import com.baitent.mvvm_retrofit_practice.util.placeholderProgressBar

class CountryAdapter(private val countryList: ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val countryNameTextView: TextView = view.findViewById(R.id.countryName)
        val imageView : ImageView= view.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.countryNameTextView.text = countryList[position].countryName
        holder.imageView.downloadImageFromUrl(countryList[position].imageUrl)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountries(newList: List<Country>) {
        countryList.clear()
        countryList.addAll(newList)
        notifyDataSetChanged()
    }
}
