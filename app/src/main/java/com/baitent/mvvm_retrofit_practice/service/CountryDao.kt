package com.baitent.mvvm_retrofit_practice.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.baitent.mvvm_retrofit_practice.models.Country

@Dao
interface CountryDao {

    //Data access object
    //veri tabanına ulaşmak istediğimiz methodların yazıldığı yer

    @Insert
    suspend fun insertAll(vararg  countries : Country) : List<Long>


    @Query("SELECT * FROM country")
    suspend fun  getAllCountries(): List<Country>


    @Query("SELECT * FROM country WHERE uuid= :countryId")
    suspend fun getCountry(countryId:Int) :Country  //detay fragmenti için tek country döndürecek

    @Query("DELETE FROM country")
    suspend fun deleteAllCountries()

}