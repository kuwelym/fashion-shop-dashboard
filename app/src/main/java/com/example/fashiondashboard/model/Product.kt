package com.example.fashiondashboard.model

data class Product(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val price: Int,
    val category: String,
    val description: String,
    val images: List<ProductImage>
)
