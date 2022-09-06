package com.example.mdpostres

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.example.mdpostres.databinding.FragmentProductsBinding

class ProductsFragment : Fragment(R.layout.fragment_products), OnClickListener {

    private lateinit var binding: FragmentProductsBinding

    private val selectedProduct = mutableListOf<Product>()

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductsBinding.bind(view)

        binding.recyclerView.adapter = ProductsAdapter(
            listOf(
                Product("Classic", "https://upload.wikimedia.org/wikipedia/commons/4/48/Dona_sencilla_mexicana.jpg", 10.5F),
                Product("Glazed", "https://p0.pikist.com/photos/921/203/donut-mini-donut-small-round-cake-torus-glaze-fat-sugar-mixture-schokoplaettchen.jpg", 2.5F),
                Product("Chocolate", "https://cdn.pixabay.com/photo/2017/04/13/23/35/dona-2228986__340.jpg", 3.5F),
                Product("Blue Berry", "https://cdn.pixabay.com/photo/2017/11/22/00/18/donuts-2969490_1280.jpg", 2.0F),
                Product("Dark Chocolate", "https://cdn.pixabay.com/photo/2017/04/12/21/18/dona-2225812_1280.jpg", 1.25f ),
                Product("Strawberry", "https://live.staticflickr.com/1338/1036945312_8e12c26d99_b.jpg", 0.75f),
                Product("Caramel", "https://p0.pxfuel.com/preview/187/392/25/cute-sweet-tasty-delicious.jpg", 5.25f),
                Product("Wine", "https://cdn.pixabay.com/photo/2017/08/11/21/46/donuts-2632878__340.jpg", 4.23f),
                Product("Penaut", "https://cdn.pixabay.com/photo/2014/02/17/17/26/donuts-268388__340.jpg", 2.05f ),
                Product("Apple", "https://cdn.pixabay.com/photo/2020/10/12/15/58/donuts-5649218__340.jpg", 1.25f),
                Product("Special", "https://live.staticflickr.com/3356/3282189390_4ba32754b6_b.jpg", 8.25f),


            ), this
        )

        binding.btnAddCar.setOnClickListener {
            //findNavController().navigate(R.id.action_productsFragment_to_carFragment)
            if (selectedProduct.size > 0) {

                val action = ProductsFragmentDirections.actionProductsFragmentToCarFragment(selectedProduct.toTypedArray())
                NavHostFragment.findNavController(this).navigate(action)
            } else {
                Toast.makeText(requireContext(), "Ningún producto seleccionado", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onClick(product: Product) {
        if (product.isSelected){
            selectedProduct.add(product)
        } else {
            selectedProduct.remove(product)
        }
    }
}