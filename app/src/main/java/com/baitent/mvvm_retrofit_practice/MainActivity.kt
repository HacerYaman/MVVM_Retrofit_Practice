package com.baitent.mvvm_retrofit_practice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        navController= Navigation.findNavController(this,R.id.main_nav)

    }
    override fun onSupportNavigateUp(): Boolean {       //ACTION BAR BACK BUTTON
        return NavigationUI.navigateUp(navController,null)
    }
}