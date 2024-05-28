package com.baitent.mvvm_retrofit_practice.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baitent.mvvm_retrofit_practice.R
import com.baitent.mvvm_retrofit_practice.adapter.CountryAdapter
import com.baitent.mvvm_retrofit_practice.viewmodel.FeedViewModel

class FeedFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var countryError: View
    private lateinit var countryLoading: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.countryList)
        countryError = view.findViewById(R.id.countryError)
        countryLoading = view.findViewById(R.id.countryLoading)

        //VIEWMODEL CONFIG
        viewModel= ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.refreshData()

        //RECYCLER VIEW CONFIG
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = countryAdapter

        observeLiveData()

    }
     fun observeLiveData(){

        viewModel.countries.observe(viewLifecycleOwner, Observer { countries ->
            countries?.let {
                viewModel.countries.observe(viewLifecycleOwner, Observer { countries ->
                    countries?.let {
                        recyclerView.visibility = View.VISIBLE
                        countryAdapter.updateCountries(it)
                    }
                })

                viewModel.countryError.observe(viewLifecycleOwner, Observer { error ->
                    error?.let {
                        countryError.visibility = if (it) View.VISIBLE else View.GONE
                    }
                })

                viewModel.countryLoading.observe(viewLifecycleOwner, Observer { loading ->
                    loading?.let {
                        countryLoading.visibility = if (it) View.VISIBLE else View.GONE
                    }
                })
            }
        })
     }
}