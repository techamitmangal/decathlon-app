package com.decathlon.app.data.remote

import com.decathlon.app.model.ProductListResponse
import com.decathlon.app.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface DecathlonService {
    @GET(Constants.GET_PRODUCT_LIST_URL)
    suspend fun getProductList(): Response<ProductListResponse>
}
