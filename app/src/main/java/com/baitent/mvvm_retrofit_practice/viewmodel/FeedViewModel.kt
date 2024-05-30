package com.baitent.mvvm_retrofit_practice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baitent.mvvm_retrofit_practice.service.CountryApiService
import com.baitent.mvvm_retrofit_practice.models.Country
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FeedViewModel : ViewModel() {

     val countries = MutableLiveData<List<Country>>()
     val countryError = MutableLiveData<Boolean>()
     val countryLoading = MutableLiveData<Boolean>()

    private val disposable = CompositeDisposable()
    private val countryApiService = CountryApiService()

    private fun getDataFromApi() {
        countryLoading.value = true

        //disposable: call yaparken her call hafızada yer tutar fragment kapatıldığında callardan kurtulmamız gerek
        // büyük obje

        disposable.add(
            countryApiService.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>() {
                    override fun onSuccess(countryList: List<Country>) {

                    }

                    override fun onError(e: Throwable) {
                        countryError.value = true
                        countryLoading.value = false
                        e.printStackTrace()
                    }
                })
        )
    }

    fun refreshData() {

        val country = Country("turkey", "asia", "www.")
        val countryFr = Country("fransa", "europa", "www.")

        val countryList = arrayListOf<Country>(country, countryFr)

        countries.value = countryList
        countryError.value = false
        countryLoading.value = false
    }
}