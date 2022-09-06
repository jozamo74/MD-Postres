package com.example.mdpostres

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mdpostres.databinding.FragmentCarBinding
import com.google.android.material.transition.MaterialSharedAxis


class CarFragment : Fragment(R.layout.fragment_car), MenuProvider {

    private val args: CarFragmentArgs by navArgs()

    private lateinit var binding: FragmentCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
    }

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

        //setHasOptionsMenu(true)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }

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

    /*  override fun onPrepareOptionsMenu(menu: Menu) {
          menu.findItem(R.id.action_confirmation).isVisible = false
          menu.findItem(R.id.confirmationFragment).isVisible = false
          super.onPrepareOptionsMenu(menu)
      }*/

    private fun sum(p: List<Product>): Float{
        var sum = 0f
        p.forEach { product ->
            sum += product.price
        }
        return sum
    }
}