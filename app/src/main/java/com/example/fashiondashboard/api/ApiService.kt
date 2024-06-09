package com.example.fashiondashboard.api

import com.example.fashiondashboard.model.Category
import com.example.fashiondashboard.model.Product
import com.example.fashiondashboard.model.ProductColor
import com.example.fashiondashboard.model.ProductImage
import com.example.fashiondashboard.model.ProductQuantity
import com.example.fashiondashboard.model.ProductSize
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("categories")
    suspend fun getCategories(): List<Category>

    @GET("categories/{id}/products")
    suspend fun getProductsByCategory(@Path ("id") id: Long): List<Product>

    @GET("products")
    suspend fun getProducts(): List<Product>

    @GET("products/{id}/product-images")
    suspend fun getProductImages(@Path("id") id: Long): List<ProductImage>

    @GET("product-quantities/{id}")
    suspend fun getProductQuantities(@Path("id") id: Long): List<ProductQuantity>

    @GET("product-quantities/{productId}/{colorId}/{sizeId}")
    suspend fun getProductQuantityByColorAndSize(@Path("productId") productId: Long, @Path("colorId") colorId: Long, @Path("sizeId") sizeId: Long): ProductQuantity

    @GET("colors/{id}")
    suspend fun getColorById(@Path("id") id: Long): ProductColor

    @GET("sizes/{id}")
    suspend fun getSizeById(@Path("id") id: Long): ProductSize
}