package com.baitent.mvvm_retrofit_practice.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baitent.mvvm_retrofit_practice.service.CountryApiService
import com.baitent.mvvm_retrofit_practice.models.Country
import com.baitent.mvvm_retrofit_practice.service.CountryDatabase
import com.baitent.mvvm_retrofit_practice.util.CustomSharedPref
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class FeedViewModel(application: Application) : BaseViewModel(application) {

    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    private val disposable = CompositeDisposable()
    private val countryApiService = CountryApiService()
    private val customSharedPref=CustomSharedPref(getApplication())

    private fun getDataFromApi() {
        countryLoading.value = true

        //disposable: call yaparken her call hafızada yer tutar fragment kapatıldığında callardan kurtulmamız gerek
        // büyük obje

        disposable.add(
            countryApiService.getData()
                .subscribeOn(Schedulers.io())
               // .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>() {
                    override fun onSuccess(countryList: List<Country>) {
                        storeInSQLite(countryList)
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

    private fun showCountries(countryList: List<Country>) {
        countries.value = countryList
        countryError.value = false
        countryLoading.value = false
    }

    private fun storeInSQLite(list: List<Country>) {
        launch {
            val dao = CountryDatabase(getApplication()).countryDao()
            dao.deleteAllCountries()
            val listLong = dao.insertAll(*list.toTypedArray()) // list -> individual
            var i = 0
            while (i < list.size) {
                list[i].uuid = listLong[i].toInt()
                i += 1
            }
            showCountries(list)
        }
        customSharedPref.saveTime(System.nanoTime())

    }

}