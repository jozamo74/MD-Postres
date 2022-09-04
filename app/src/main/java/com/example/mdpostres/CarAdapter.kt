package com.example.mdpostres

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mdpostres.databinding.ItemCarBinding

/****
 * Project: MD Postres
 * From: com.example.mdpostres
 * Created by José Zambrano Moya on 1/9/22 at 18:21
 * More info: zambranomoya74@gmail.com
 ****/
class CarAdapter(
    private val products: List<Product>
) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {

            Log.d("car", "ViewHolder()")
            binding.tvName.text = product.name
            binding.tvPrice.text = "${product.price} €"
        }


    }

    // create new view when the recyclerview ask
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCarBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        Log.d("car", "onCreateViewHolder() IN C")
        return ViewHolder(binding)
    }

    // Update view when the adapter ask
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = products[position]
        Log.d("CAR", "CAR:$product")
        holder.bind(product)
    }


    override fun getItemCount() = products.size
}