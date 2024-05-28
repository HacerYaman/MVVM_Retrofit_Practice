package com.baitent.mvvm_retrofit_practice.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.baitent.mvvm_retrofit_practice.R
import com.baitent.mvvm_retrofit_practice.viewmodel.CountryViewModel
import com.baitent.mvvm_retrofit_practice.viewmodel.FeedViewModel

class CountryFragment : Fragment() {

    private lateinit var viewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel= ViewModelProvider(this).get(CountryViewModel:: class.java)

        viewModel.getDataFromRoom()
        observeLiveData()

    }

    private fun observeLiveData(){
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer{
            country -> country?.let {
               // countryName.text=country.countryName
        }
        })
    }

}