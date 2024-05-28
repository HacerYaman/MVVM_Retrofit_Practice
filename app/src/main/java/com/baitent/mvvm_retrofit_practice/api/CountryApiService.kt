package com.baitent.mvvm_retrofit_practice.api

import com.baitent.mvvm_retrofit_practice.models.Country
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountryApiService {
    private val BASE_URL = ""


    private val api =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
            .create(CountryApi::class.java)

    fun getData(): Single<List<Country>>{
        return api.getCountries()
    }

}