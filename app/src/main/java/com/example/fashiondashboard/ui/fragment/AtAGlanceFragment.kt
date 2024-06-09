package com.example.fashiondashboard.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fashiondashboard.R
import com.example.fashiondashboard.databinding.FragmentAtAGlanceBinding
import com.example.fashiondashboard.factory.ProductViewModelFactory
import com.example.fashiondashboard.repository.ProductRepository
import com.example.fashiondashboard.viewmodel.ProductViewModel

class AtAGlanceFragment : Fragment() {
    private val productRepository = ProductRepository()
    private val productViewModel: ProductViewModel by viewModels { ProductViewModelFactory(
        requireContext(),  productRepository
    ) }
    private lateinit var binding: FragmentAtAGlanceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_at_a_glance, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = productViewModel

        productViewModel.navigateToAllProducts.observe(viewLifecycleOwner) { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.allProductsActivity)
                productViewModel.onNavigatedToAllProducts()
            }
        }
        return binding.root
    }
}