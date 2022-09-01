package com.example.mdpostres

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mdpostres.databinding.FragmentCarBinding


class CarFragment : Fragment(R.layout.fragment_car) {

    private lateinit var binding: FragmentCarBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCarBinding.bind(view)

        binding.btnback.setOnClickListener {
            findNavController().navigate(R.id.action_carFragment_to_productsFragment)
        }

    }
}