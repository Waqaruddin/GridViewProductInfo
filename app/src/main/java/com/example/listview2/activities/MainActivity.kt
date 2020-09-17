package com.example.listview2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listview2.R
import com.example.listview2.adapters.AdapterFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        var adapterFragment = AdapterFragment(supportFragmentManager)

        adapterFragment.addFragment("Mobile")
        adapterFragment.addFragment("Laptop")
//        adapterFragment.addFragment("Desktop")

        view_pager.adapter = adapterFragment
        tab_layout.setupWithViewPager(view_pager)
    }
}