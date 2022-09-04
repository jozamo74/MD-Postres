package com.example.mdpostres

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mdpostres.databinding.ItemProductBinding


/****
 * Project: MD Postres
 * From: com.example.mdpostres
 * Created by José Zambrano Moya on 31/8/22 at 10:26
 * More info: zambranomoya74@gmail.com
 ****/
class ProductsAdapter(
    private val products: List<Product>,
    private val listener: OnClickListener

) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setListener(product: Product, listener: OnClickListener){
            binding.containerItemProduct.setOnClickListener {
                product.isSelected = !product.isSelected
                binding.containerItemProduct.isChecked = product.isSelected
                listener.onClick(product)
            }
        }

        fun bind(product: Product) {
            binding.tvName.text = product.name
            binding.tvPrice.text = "${product.price} €"
            Glide
                .with(binding.root.context)
                .load(product.url)
                .apply(RequestOptions.centerCropTransform())
                .into(binding.imgPhoto)
        }


    }

    // create new view when the recyclerview ask
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
//        return ViewHolder(view)

        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        Log.d("car", "onCreateViewHolder() IN P")
        return ViewHolder(binding)
    }


    // Update view when the adapter ask
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = products[position]

        holder.bind(product)
        holder.setListener(product, listener)

//        holder.itemView.setOnClickListener {
//            onClickListener.onClick(product)
//        }
    }

    override fun getItemCount() = products.size


}