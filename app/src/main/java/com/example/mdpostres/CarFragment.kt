package com.example.mdpostres

import android.os.Bundle
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

        binding.tvSum.text = getString(R.string.car_sum, sum(productList))

        binding.recyclerView.adapter = CarAdapter(productList)

        binding.btnback.setOnClickListener {
            findNavController().navigate(R.id.action_carFragment_to_productsFragment)
        }

        binding.btnPay.setOnClickListener {
            findNavController().navigate(R.id.action_carFragment_to_confirmationFragment)
        }

    }

    private fun sum(p: List<Product>): Float{
        var sum = 0f
        p.forEach { product ->
            sum += product.price
        }
        return sum
    }
}