package com.example.listview2.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.listview2.fragments.ProductListFragment

class AdapterFragment(fm:FragmentManager):FragmentPagerAdapter(fm){

    var mFragmentList:ArrayList<Fragment> = ArrayList()
    var mTitleList:ArrayList<String> = ArrayList()

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getItem(position: Int): Fragment{
        return mFragmentList.get(position)


    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitleList.get(position)
    }

    fun addFragment(productName:String){
        mFragmentList.add(ProductListFragment.newInstance(productName))
        mTitleList.add(productName)
    }

}