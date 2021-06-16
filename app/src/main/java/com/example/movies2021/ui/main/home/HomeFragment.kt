package com.example.movies2021.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movies2021.R
import com.example.movies2021.data.model.response.Result
import com.example.movies2021.di.components.AppComponent
import com.example.movies2021.di.components.DaggerAppComponent
import com.example.movies2021.ui.main.home.adapter.HomeRecyclerAdapter
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class HomeFragment : Fragment() {
    lateinit var component: AppComponent

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, homeViewModelFactory)
            .get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.home_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupInjection()

        viewModel.results.observe(viewLifecycleOwner,{
            val resultsList = mutableListOf<Result>()
            val adapter = HomeRecyclerAdapter(resultsList)
            recyclerView.adapter = adapter
        })
    }

    private fun setupInjection() {
        component = DaggerAppComponent.builder()
            .build()
        component.inject(this)
    }




}
