package com.mobile.bce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.bce.R
import com.mobile.bce.model.product

class ProductAdapter (private val prductList: List<product>) :
RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    class ProductViewHolder(view: View):RecyclerView.ViewHolder(view){
        val img: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)
        val price: TextView = view.findViewById(R.id.price)
        val rating: TextView = view.findViewById(R.id.rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount() = prductList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = prductList[position]
        holder.title.text= product.title
        holder.price.text = "$${product.price}"
        holder.rating.text = " ${product.rating.rate} (${product.rating.count})"

        Glide.with(holder.itemView.context)
            .load(product.image)
            .into(holder.img)
    }


}