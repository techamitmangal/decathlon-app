package com.decathlon.app

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.decathlon.app.adapter.ProductListAdapter
import com.decathlon.app.databinding.ActivityMainBinding
import com.decathlon.app.utils.NetworkResult
import com.decathlon.app.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var _binding: ActivityMainBinding
    val adapter = ProductListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        _binding.recyclerview.adapter = adapter
        fetchData()
    }

    private fun fetchData() {
        fetchResponse()
        mainViewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let {
                        adapter.setMovieList(response.data.products)
                    }
                    _binding.progressBar.visibility = View.GONE
                }

                is NetworkResult.Error -> {
                    _binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        this,
                        response.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is NetworkResult.Loading -> {
                    _binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun fetchResponse() {
        mainViewModel.fetchDogResponse()
        _binding.progressBar.visibility = View.VISIBLE
    }
}
