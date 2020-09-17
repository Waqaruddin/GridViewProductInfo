package com.example.listview2.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.listview2.R
import com.example.listview2.activities.ProductDetails
import com.example.listview2.activities.Products
import kotlinx.android.synthetic.main.row_list_adapter.view.*

//class AdapterProducts(var nContext:Context, var mList:ArrayList<Products>):BaseAdapter(){
//    override fun getCount(): Int {
//        return mList.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return mList.get(position)
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val view = LayoutInflater.from(nContext).inflate(R.layout.row_list_adapter, parent, false)
//
//
//
//
//        var product = mList.get(position)
//        view.text_view_product_name.text = product.title
//        view.text_view_description.text = product.description
//        view.image_view_product.setImageResource(product.img)
//
//
//        return view
//    }
//
//
//}

class AdapterProducts(var mContext: Context, var mList:ArrayList<Products>): RecyclerView.Adapter<AdapterProducts.MyViewHolder>(){

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(products: Products){
            itemView.text_view_product_name.text = products.title
            itemView.text_view_description.text = products.description
            itemView.image_view_product.setImageResource(products.img)

            itemView.image_view_product.setOnClickListener {
                Toast.makeText(mContext, "Image Clicked", Toast.LENGTH_SHORT).show()
            }

            itemView.setOnClickListener {
                Toast.makeText(mContext, products.title, Toast.LENGTH_SHORT).show()
            }



        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterProducts.MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(
            R.layout.row_list_adapter, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterProducts.MyViewHolder, position: Int) {
        var products = mList.get(position)
        holder.bind(products)
    }

    override fun getItemCount(): Int {
        return mList.size

    }


}