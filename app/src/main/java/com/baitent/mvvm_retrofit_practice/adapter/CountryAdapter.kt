package com.baitent.mvvm_retrofit_practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baitent.mvvm_retrofit_practice.R
import com.baitent.mvvm_retrofit_practice.models.Country

class CountryAdapter(val countyList: ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    class CountryViewHolder(var view: View): RecyclerView.ViewHolder(view){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
       //layout ile adapterin birbirine bağlandığı yer
        var inflater=LayoutInflater.from(parent.context)
        val view= inflater.inflate(R.layout.item_country,parent,false)

        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        //layout içindeki itemlere erişebiliyoruz. artık her şey bağlı. holder çağır

        //holder.view.nameText=countryList[position].countryName
    }

    override fun getItemCount(): Int {
        return countyList.size
    }

    fun updateCountries(newList: List<Country>){

    }
}