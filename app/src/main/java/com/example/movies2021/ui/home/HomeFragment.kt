package com.example.movies2021.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.movies2021.R
import com.example.movies2021.data.models.Result
import com.example.movies2021.ui.home.adapter.HomeRecyclerAdapter
import com.example.movies2021.utils.Constants
import com.example.movies2021.utils.ResourceState
import com.example.movies2021.utils.extensions.showSnackbar
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.android.synthetic.main.home_fragment.*

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val TAG = "Keefa"

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.home_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getMovies()
    }

    private fun getMovies() {
        viewModel.getResults().observe(viewLifecycleOwner, { resources ->
            when (resources.state) {
                ResourceState.LOADING -> {
                    view?.showSnackbar("welcome to keefa movies")
                }
                ResourceState.SUCCESS -> {
                    resources.data?.let { results ->
                        setUpAdapter(results.results)
                    }
                }
                ResourceState.ERROR -> {
                    resources.message.let {
                        view?.showSnackbar(it!!)
                    }
                }
            }


        })
    }

    private fun setUpAdapter(results: List<Result>) {
        val adapter = HomeRecyclerAdapter(results)
        recyclerView.adapter = adapter

    }


}
