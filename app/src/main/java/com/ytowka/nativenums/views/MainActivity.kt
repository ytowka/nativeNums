package com.ytowka.nativenums.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.ytowka.nativenums.presentor.App
import com.ytowka.nativenums.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
    companion object{
        fun printd(massege: String){
            Log.i("debug",massege)
        }
    }
    lateinit var app: App
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app = applicationContext as App

        val list = listOf(PrimeNumFragment(resources.getString(R.string.primeNums)), NodFragment(resources.getString(
            R.string.NN)))
        viewPager.adapter = TabAdapter(this, list)
        TabLayoutMediator(tabLayout, viewPager){ tab, pos ->
            tab.text = list[pos].name
        }.attach()
    }
}

