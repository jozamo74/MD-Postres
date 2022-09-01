package com.example.mdpostres

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.mdpostres.databinding.FragmentProductsBinding

class ProductsFragment : Fragment(R.layout.fragment_products), OnClickListener {

    private lateinit var binding: FragmentProductsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductsBinding.bind(view)

        binding.recyclerView.adapter = ProductsAdapter(
            listOf(
                Product("Classic", "https://upload.wikimedia.org/wikipedia/commons/4/48/Dona_sencilla_mexicana.jpg"),
                Product("Glazed", "https://p0.pikist.com/photos/921/203/donut-mini-donut-small-round-cake-torus-glaze-fat-sugar-mixture-schokoplaettchen.jpg"),
                Product("Chocolate", "https://cdn.pixabay.com/photo/2017/04/13/23/35/dona-2228986__340.jpg"),
                Product("Blue Berry", "https://loremflickr.com/320/240?lock=4"),
                Product("Dark Chocolate", "https://cdn.pixabay.com/photo/2017/11/22/00/18/donuts-2969490_1280.jpg" ),
                Product("Strawberry", "https://live.staticflickr.com/1338/1036945312_8e12c26d99_b.jpg" ),
                Product("Caramel", "https://p0.pxfuel.com/preview/187/392/25/cute-sweet-tasty-delicious.jpg" ),
                Product("Wine", "https://cdn.pixabay.com/photo/2017/08/11/21/46/donuts-2632878__340.jpg" ),
                Product("Penaut", "https://cdn.pixabay.com/photo/2014/02/17/17/26/donuts-268388__340.jpg" ),
                Product("Apple", "https://cdn.pixabay.com/photo/2020/10/12/15/58/donuts-5649218__340.jpg" ),
                Product("Special", "https://live.staticflickr.com/3356/3282189390_4ba32754b6_b.jpg" ),


            ), this
        )

        binding.btnAddCar.setOnClickListener {
            //findNavController().navigate(R.id.action_productsFragment_to_carFragment)
            NavHostFragment.findNavController(this).navigate(R.id.action_productsFragment_to_carFragment)
        }

    }

    override fun onClick(product: Product) {
        Toast.makeText(requireContext(), "${product.name}, ${product.isSelected}", Toast.LENGTH_SHORT).show()
    }

}