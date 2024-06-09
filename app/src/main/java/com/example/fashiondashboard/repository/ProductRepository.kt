package com.example.fashiondashboard.repository

import com.example.fashiondashboard.api.RetrofitInstance
import com.example.fashiondashboard.model.Category
import com.example.fashiondashboard.model.Product
import com.example.fashiondashboard.model.ProductColor
import com.example.fashiondashboard.model.ProductImage
import com.example.fashiondashboard.model.ProductQuantity
import com.example.fashiondashboard.model.ProductSize
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepository {
    suspend fun getCategories(): List<Category> {
        return withContext(Dispatchers.IO) {
            RetrofitInstance.api.getCategories()
        }
    }

    suspend fun getProductsByCategory(id: Long): List<Product> {
        return withContext(Dispatchers.IO) {
            RetrofitInstance.api.getProductsByCategory(id)
        }
    }

    suspend fun getProducts(): List<Product> {
        return withContext(Dispatchers.IO) {
            RetrofitInstance.api.getProducts()
        }
    }

    suspend fun getProductImages(id: Long): List<ProductImage> {
        return withContext(Dispatchers.IO) {
            RetrofitInstance.api.getProductImages(id)
        }
    }

    suspend fun getProductQuantityByColorAndSize(productId: Long, colorId: Long, sizeId: Long): ProductQuantity {
        return withContext(Dispatchers.IO) {
            RetrofitInstance.api.getProductQuantityByColorAndSize(productId, colorId, sizeId)
        }
    }

    suspend fun getColorById(id: Long): ProductColor {
        return withContext(Dispatchers.IO) {
            RetrofitInstance.api.getColorById(id)
        }
    }

    suspend fun getSizeById(id: Long): ProductSize {
        return withContext(Dispatchers.IO) {
            RetrofitInstance.api.getSizeById(id)
        }
    }

    suspend fun getProductQuantities(id: Long) : List<ProductQuantity>{
        return withContext(Dispatchers.IO) {
            RetrofitInstance.api.getProductQuantities(id)
        }
    }
}