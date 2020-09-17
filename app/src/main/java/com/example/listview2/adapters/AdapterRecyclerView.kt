package com.example.listview2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listview2.R
import com.example.listview2.activities.Products
import kotlinx.android.synthetic.main.row_list_adapter.view.*


class AdapterRecyclerView(var mContext: Context, var mList:ArrayList<Products>):RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder>(){



    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(products: Products){
            itemView.text_view_product_name.text = products.title
            itemView.text_view_description.text = products.description
            itemView.image_view_product.setImageResource(products.img)



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_list_adapter, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var products = mList.get(position)
        holder.bind(products)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}