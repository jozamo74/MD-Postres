package com.example.mdpostres

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mdpostres.databinding.FragmentConfirmationBinding

class ConfirmationFragment : Fragment(R.layout.fragment_confirmation) {

    private lateinit var binding: FragmentConfirmationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConfirmationBinding.bind(view)

        binding.bntDone.setOnClickListener {
            findNavController().navigate(R.id.action_confirmationFragment_to_productsFragment)
        }
    }
}