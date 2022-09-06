package com.example.mdpostres

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.mdpostres.databinding.FragmentConfirmationBinding

class ConfirmationFragment : Fragment(R.layout.fragment_confirmation),  MenuProvider{

    private lateinit var binding: FragmentConfirmationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConfirmationBinding.bind(view)

        binding.bntDone.setOnClickListener {
            findNavController().navigate(R.id.action_confirmationFragment_to_productsFragment)
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    /**
     * Called by the [MenuHost] to allow the [MenuProvider]
     * to inflate [MenuItem]s into the menu.
     *
     * @param menu         the menu to inflate the new menu items into
     * @param menuInflater the inflater to be used to inflate the updated menu
     */
    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.findItem(R.id.action_confirmation).isVisible = false
        menu.findItem(R.id.confirmationFragment).isVisible = false
    }

    /**
     * Called by the [MenuHost] when a [MenuItem] is selected from the menu.
     *
     * @param menuItem the menu item that was selected
     * @return `true` if the given menu item is handled by this menu provider,
     * `false` otherwise
     */
    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}