package com.example.fashiondashboard.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fashiondashboard.model.Category
import com.example.fashiondashboard.model.Product
import com.example.fashiondashboard.model.ProductColor
import com.example.fashiondashboard.model.ProductImage
import com.example.fashiondashboard.model.ProductQuantity
import com.example.fashiondashboard.model.ProductSize
import com.example.fashiondashboard.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(private val context: Context, private val productRepository: ProductRepository) : ViewModel() {

    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> get() = _categories

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    private val _productImages = MutableLiveData<List<ProductImage>>()
    val productImages: LiveData<List<ProductImage>> get() = _productImages

    private val _productQuantity = MutableLiveData<ProductQuantity>()
    val productQuantity: LiveData<ProductQuantity> get() = _productQuantity

    private val _color = MutableLiveData<ProductColor>()
    val color: LiveData<ProductColor> get() = _color

    private val _size = MutableLiveData<ProductSize>()
    val size: LiveData<ProductSize> get() = _size

    private val _productQuantities = MutableLiveData<List<ProductQuantity>>()
    val productQuantities: LiveData<List<ProductQuantity>> get() = _productQuantities

    fun fetchCategories() {
        viewModelScope.launch {
            try {
                val categoryList = productRepository.getCategories()

            } catch (e: Exception) {
                // Handle the error
                Log.e("ProductViewModel", "Error fetching categories", e)
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                val productList = productRepository.getProducts()
                _products.value = productList
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

    fun fetchProductsByCategory(id: Long) {
        viewModelScope.launch {
            try {
                val productList = productRepository.getProductsByCategory(id)
                _products.value = productList
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

    fun fetchProductImages(id: Long) {
        viewModelScope.launch {
            try {
                _productImages.value = productRepository.getProductImages(id)
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

    fun fetchProductQuantityByColorAndSize(productId: Long, colorId: Long, sizeId: Long) {
        viewModelScope.launch {
            try {
                _productQuantity.value = productRepository.getProductQuantityByColorAndSize(productId, colorId, sizeId)
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

    fun fetchColorById(id: Long) {
        viewModelScope.launch {
            try {
                _color.value = productRepository.getColorById(id)
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

    fun fetchSizeById(id: Long) {
        viewModelScope.launch {
            try {
                _size.value = productRepository.getSizeById(id)
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

    fun fetchProductQuantities(id: Long) {
        viewModelScope.launch {
            try {
                _productQuantities.value = productRepository.getProductQuantities(id)
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

    private val _navigateToAllProducts = MutableLiveData<Boolean>()
    val navigateToAllProducts: LiveData<Boolean> get() = _navigateToAllProducts

    fun onTotalProductsCardClick() {
        Log.d("ProductViewModel", "onTotalProductsCardClick")
        _navigateToAllProducts.value = true
    }

    fun onNavigatedToAllProducts() {
        Log.d("ProductViewModel", "onNavigatedToAllProducts")
        _navigateToAllProducts.value = false
    }
}