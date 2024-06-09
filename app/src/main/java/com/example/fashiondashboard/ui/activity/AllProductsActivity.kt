package com.example.fashiondashboard.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.fashiondashboard.R
import com.example.fashiondashboard.databinding.ActivityAllProductsBinding
import com.example.fashiondashboard.factory.ProductViewModelFactory
import com.example.fashiondashboard.repository.ProductRepository
import com.example.fashiondashboard.viewmodel.ProductViewModel

class AllProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAllProductsBinding

    private val productRepository = ProductRepository()
    private val productViewModel: ProductViewModel by viewModels { ProductViewModelFactory(
       this , productRepository
    ) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_products)
        binding.lifecycleOwner = this
        binding.viewModel = productViewModel

        // Observe LiveData
        productViewModel.categories.observe(this) { categories ->
            Log.d("AllProductsActivity", "Categories: $categories")
            // Update category UI
        }

        productViewModel.products.observe(this) { products ->
            Log.d("AllProductsActivity", "Products: $products")
            // Update products UI
        }

        productViewModel.productImages.observe(this) { images ->
            Log.d("AllProductsActivity", "Images: $images")
            // Update images UI
        }

        // Fetch initial data
        productViewModel.fetchCategories()
        productViewModel.fetchProducts()
    }
}