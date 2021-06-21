package com.example.movies2021.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movies2021.R
import com.example.movies2021.ui.adapter.HomeRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.android.synthetic.main.home_fragment.*
@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.home_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.results.observe(viewLifecycleOwner,{results->
            val adapter = HomeRecyclerAdapter(results)
            recyclerView.adapter = adapter

        })
    }





}
