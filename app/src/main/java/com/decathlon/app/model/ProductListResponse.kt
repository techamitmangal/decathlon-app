package com.decathlon.app.model

import com.google.gson.annotations.SerializedName

data class ProductListResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("products")
    val products: List<ProductItem>
)
