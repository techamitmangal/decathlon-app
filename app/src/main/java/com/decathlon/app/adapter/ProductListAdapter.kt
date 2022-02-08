package com.decathlon.app.adapter
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.decathlon.app.databinding.ProductListItemBinding
import com.decathlon.app.model.ProductItem

class ProductListAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var products = mutableListOf<ProductItem>()

    fun setMovieList(products: List<ProductItem>) {
        this.products = products.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductListItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val product = products[position]
        holder.binding.textViewTitle.text = product.title
        holder.binding.textViewPrice.text = "₹ " + product.price.toString()
        holder.binding.textViewDiscountPrice.text = "₹ " + product.discountPrice.toString()
        holder.binding.textViewPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        Glide.with(holder.itemView.context).load(product.imageUrl).into(holder.binding.imageView)
    }

    override fun getItemCount(): Int {
        return products.size
    }
}

class MainViewHolder(val binding: ProductListItemBinding) : RecyclerView.ViewHolder(binding.root) {

}