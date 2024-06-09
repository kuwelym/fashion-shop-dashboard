package com.example.fashiondashboard.model

data class ProductQuantity(
    val id: Long,
    val productId: Long,
    val color: ProductColor,
    val size: ProductSize,
    val quantity: Int
)
