package com.baitent.mvvm_retrofit_practice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


//buradan obje oluşturulmayacak sadece extend edilcek o yüzden abstrack yapmalıyız
abstract class BaseViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job+ Dispatchers.Main //öncelikle arka planda işini yap sonra main threade dön


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}