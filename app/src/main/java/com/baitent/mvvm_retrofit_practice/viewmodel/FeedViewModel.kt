package com.baitent.mvvm_retrofit_practice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baitent.mvvm_retrofit_practice.models.Country

class FeedViewModel: ViewModel() {

    val countries= MutableLiveData<List<Country>>()
    val countryError= MutableLiveData<Boolean>()
    val countryLoading= MutableLiveData<Boolean>()

    fun refreshData(){

        val country= Country("turkey","asia","www.")
        val countryFr= Country("fransa","europa","www.")

        val countryList= arrayListOf<Country>(country,countryFr)

        countries.value=countryList
        countryError.value=false
        countryLoading.value=false
    }
}