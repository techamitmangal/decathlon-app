package com.decathlon.app.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val decathlonService: DecathlonService) {
    suspend fun getProductList() =
        decathlonService.getProductList()
}