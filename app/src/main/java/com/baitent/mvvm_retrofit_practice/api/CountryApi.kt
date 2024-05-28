package com.baitent.mvvm_retrofit_practice.api

import com.baitent.mvvm_retrofit_practice.models.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryApi {

    //GET POST

    @GET("ext url")
    fun getCountries(): Single<List<Country>>
}