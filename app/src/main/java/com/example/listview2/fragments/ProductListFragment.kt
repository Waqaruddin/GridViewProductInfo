package com.example.listview2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.listview2.R
import com.example.listview2.activities.Products
import com.example.listview2.adapters.AdapterProducts
import kotlinx.android.synthetic.main.fragment_product_list.view.*

private const val ARG_PARAM1 = "param1"
class ProductListFragment : Fragment() {

    var mList:ArrayList<Products> = ArrayList()
    private var productName: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            productName = it.getString(ARG_PARAM1)
        }

        generateData(productName!!)
    }

    fun generateData(productName:String){
        when(productName){
            "Mobile" -> {

                mList.add(Products("Galaxy s20", "$999.99", R.drawable.galaxy))
                mList.add(Products("note 20", "$999.99", R.drawable.notetwenty))
                mList.add(Products("Galaxy Z Flip 5G", "$1449.99", R.drawable.zflip))
                mList.add(Products("Galaxy A51", "$324.99", R.drawable.afiftyone))
                mList.add(Products("Iphone 11 pro", "$999", R.drawable.elevenpro))
                mList.add(Products("Iphone 11 pro Max", "$1099", R.drawable.promax))
                mList.add(Products("Iphone XR", "$599", R.drawable.xr))
                mList.add(Products("Iphone 11", "$699", R.drawable.eleven))


            }
            "Desktop" -> {
                mList.add(Products("Xps", "A desktop ", R.drawable.xps))

            }

            "Laptop" -> {
                mList.add(Products("Spectre X360", "$1099.00", R.drawable.hp_spectre))
                mList.add(Products("Surface 3", "$999.99", R.drawable.surface))
                mList.add(Products("Lenovo IdeaPad", "$379.99 ", R.drawable.ideapad))
                mList.add(Products("XPS 15", "$1099.00 ", R.drawable.xps2))
                mList.add(Products("Macbook Air", "$999.00", R.drawable.macair))
                mList.add(Products("Macbook Pro", "$1199.99 ", R.drawable.macpro))

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_product_list, container, false)

        init(view)
        return view
    }

    private fun init(view: View) {
        var adapterProduct = AdapterProducts(activity!!, mList)
        view.fragment_recycler_view.layoutManager = GridLayoutManager(activity!!, 2)
        view.fragment_recycler_view.adapter = adapterProduct


    }


    companion object {
        @JvmStatic
        fun newInstance(productName: String) =
            ProductListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, productName)

                }
            }
    }


}