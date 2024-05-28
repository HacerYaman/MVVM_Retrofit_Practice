package com.baitent.mvvm_retrofit_practice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baitent.mvvm_retrofit_practice.models.Country

class CountryViewModel : ViewModel() {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(){

        val country=Country("turkey", "asia","ww")

        countryLiveData.value=country
    }
}