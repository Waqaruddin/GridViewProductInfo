package com.example.listview2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listview2.R
import com.example.listview2.activities.Products
import com.example.listview2.adapters.AdapterRecyclerView
import kotlinx.android.synthetic.main.fragment_recycler.view.*

private const val ARG_PARAM1 = "param1"
class RecyclerFragment : Fragment() {

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
            "Playstation" -> {
                mList.add(Products("PS4", "Older playstation", R.drawable.galaxy))
                mList.add(Products("PS5", "Newest version of the playstation", R.drawable.iphonex))

            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_recycler, container, false)

        init(view)
        return view
    }

    private fun init(view: View) {
        generateData(productName!!)
        var adapterRecycle = AdapterRecyclerView(activity!!, mList)
        view.fragment_recycler_view.layoutManager = LinearLayoutManager(activity!!)
        view.fragment_recycler_view.adapter = adapterRecycle


    }

    companion object {

        @JvmStatic
        fun newInstance(productName: String) =
            RecyclerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, productName)
                }
            }
    }
}