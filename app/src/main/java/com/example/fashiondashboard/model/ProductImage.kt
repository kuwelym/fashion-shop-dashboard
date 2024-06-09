package com.example.fashiondashboard.model

import com.google.gson.annotations.SerializedName

data class ProductImage(
    val id: Long,
    val productId: Long,
    @SerializedName("imagePath")
    val imageUrl: String
)
