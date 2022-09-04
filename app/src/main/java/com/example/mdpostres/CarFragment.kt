package com.example.mdpostres

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mdpostres.databinding.FragmentCarBinding


class CarFragment : Fragment(R.layout.fragment_car) {

    private val args: CarFragmentArgs by navArgs()

    private lateinit var binding: FragmentCarBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCarBinding.bind(view)

        val productList: List<Product> = args.products.toList()

        Log.d("car", "Procucts: $productList  \n size:${productList.size}")

        binding.recyclerView.adapter = CarAdapter(productList)

        binding.btnback.setOnClickListener {
            findNavController().navigate(R.id.action_carFragment_to_productsFragment)
        }

    }
}