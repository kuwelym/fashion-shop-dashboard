package com.example.fashiondashboard.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fashiondashboard.repository.ProductRepository
import com.example.fashiondashboard.viewmodel.ProductViewModel

class ProductViewModelFactory(private val context: Context, private val productRepository: ProductRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductViewModel(context, productRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}