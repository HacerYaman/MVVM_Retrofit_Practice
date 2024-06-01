package com.baitent.mvvm_retrofit_practice.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit

class CustomSharedPref {

    //singleton
    companion object{


        private const val PREFERENCES_TIME="preferences_time"
        private var sharedPref:SharedPreferences?=null

        @Volatile private var instance : CustomSharedPref? = null
        private val lock= Any()

        operator fun invoke(context: Context): CustomSharedPref= instance?: synchronized(lock){
            instance?: makeCustomSharedPref(context).also {
                instance = CustomSharedPref()
            }
        }

        private fun makeCustomSharedPref(context: Context): CustomSharedPref{
            sharedPref= PreferenceManager.getDefaultSharedPreferences(context)
            return CustomSharedPref()
        }
    }

    fun saveTime(time : Long){
        sharedPref?.edit(commit = true){
            putLong(PREFERENCES_TIME,time)
        }
    }


}


