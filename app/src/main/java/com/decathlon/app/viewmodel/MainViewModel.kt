package com.decathlon.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.decathlon.app.data.Repository
import com.decathlon.app.model.ProductListResponse
import com.decathlon.app.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor
    (
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {

    private val _response: MutableLiveData<NetworkResult<ProductListResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<ProductListResponse>> = _response

    fun fetchDogResponse() = viewModelScope.launch {
        repository.getProductList().collect { values ->
            _response.value = values
        }
    }

}