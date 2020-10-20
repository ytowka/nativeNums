package com.ytowka.nativenums.views

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(af: FragmentActivity,private val list: List<Fragment>) : FragmentStateAdapter(af) {
    override fun getItemCount(): Int {
       return list.size;
    }
    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}