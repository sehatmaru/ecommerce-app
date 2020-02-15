package com.app.ecommerce.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.app.ecommerce.R
import com.app.network.model.ProductItem
import com.app.uicustom.adapter.BaseHolder
import kotlinx.android.synthetic.main.adapter_product.view.*

class ProductAdapter(private val listener: ProductItemAdapterListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = ArrayList<ProductItem>()

    inner class ViewHolder(parent: ViewGroup) : BaseHolder(R.layout.adapter_product, parent){

        fun bind(data: ProductItem){
            itemView.img.setImageResource(data.image)
            itemView.brand.text = data.brand
            itemView.name.text = data.name
            itemView.price.text = data.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = ViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[holder.adapterPosition]
        val viewHolder = holder as ViewHolder

        viewHolder.bind(item)
        viewHolder.itemView.setOnClickListener{
            listener.onClickProductItemAdapter(item)
        }
    }

    fun initData(items: ArrayList<ProductItem>){
        this.items = items
        notifyDataSetChanged()
    }

    interface ProductItemAdapterListener{
        fun onClickProductItemAdapter(item: ProductItem)
    }
}
