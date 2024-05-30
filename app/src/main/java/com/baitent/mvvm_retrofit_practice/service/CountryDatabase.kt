package com.baitent.mvvm_retrofit_practice.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.baitent.mvvm_retrofit_practice.models.Country

@Database(entities = arrayOf(Country::class), version = 1)
abstract class CountryDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDao

    //singleton mantığıyla oluşturulmalı. tek bir nesne oluşturulmalı. singleton yapma mantığımızın sebebi farklı threadlerde çalışıyo olmamız

    //volatile -> herhangi bir propertiyi volatile olarak işaretlediğimizde farklı threadlere de görünür hale geliyo

    //synchronized Bloğu: synchronized bloğu, aynı anda sadece tek bir iş parçacığının bu bloğa erişmesini sağlar. Bu, aynı anda birden fazla iş parçacığının CountryDatabase örneğini oluşturmasını engeller.

    //invoke Fonksiyonu: invoke fonksiyonu, CountryDatabase örneğini almak için kullanılır. Eğer instance null ise, synchronized bloğuna girilir ve makeDatabase fonksiyonu çağrılarak yeni bir CountryDatabase örneği oluşturulur.

    //makeDatabase Fonksiyonu: Bu fonksiyon, Room kütüphanesinin databaseBuilder fonksiyonunu kullanarak CountryDatabase örneğini oluşturur.

    companion object{
       @Volatile private var instance:CountryDatabase? =null


        private val lock= Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: makeDatabase(context).also { instance = it } // instance = country database
        }

        private fun makeDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, CountryDatabase::class.java, "countryDatabase").build()


    }

}