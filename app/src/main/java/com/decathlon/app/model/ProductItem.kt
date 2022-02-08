package com.decathlon.app.model
import com.google.gson.annotations.SerializedName
data class ProductItem (
    @SerializedName("productId")
    val productId: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("discountPrice")
    val discountPrice: Int,
    @SerializedName("weight")
    val weight: Int,
    @SerializedName("length")
    val length: Int,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("numberRemaining")
    val numberRemaining: Int,
    @SerializedName("numberSold")
    val numberSold: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("isBuyable")
    val isBuyable: Boolean,
    @SerializedName("isShippable")
    val isShippable: Boolean,
    @SerializedName("isFeaturedNew")
    val isFeaturedNew: Boolean,
    @SerializedName("inPromotion")
    val inPromotion: Boolean,
    @SerializedName("isOos")
    val isOos: Boolean,
)