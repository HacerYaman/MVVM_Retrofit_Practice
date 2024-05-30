package com.baitent.mvvm_retrofit_practice.service

import com.baitent.mvvm_retrofit_practice.models.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryApi {

    //GET POST

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries(): Single<List<Country>>
}