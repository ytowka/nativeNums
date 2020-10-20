package com.ytowka.nativenums.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ytowka.nativenums.presentor.App.Companion.int
import com.ytowka.nativenums.model.Named
import com.ytowka.nativenums.R
import kotlinx.android.synthetic.main.fragment_native_num.*

class PrimeNumFragment(override var name: String) : Fragment(), Named, PrimeNumFragInterface {
    constructor() : this("dum")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        avedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_native_num, container, false)
    }

    override fun onStart() {
        super.onStart()
        val presentor = (activity as MainActivity).app.pmPresentor
        presentor.fragmentInterface = this
        //calcButton.setText(R.string.calculate)
        loading.visibility = View.GONE
        if(presentor.calculator.isCalculating()){
            loading.visibility = View.VISIBLE
            calcButton.setText(R.string.cancel)
        }
        if(presentor.result != null){
            setData(presentor.result!!)
        }
        calcButton.setOnClickListener {
            if (!presentor.calculator.isCalculating()) {
                calcButton.setText(R.string.cancel)
                loading.visibility = View.VISIBLE
                leftText.text = ""
                rightText.text = ""
               presentor.calculate(textEdit.int())
            } else {
                calcButton.setText(R.string.calculate)
                presentor.stop()
            }
        }

    }
    override fun onCalculationEnd(map: Map<Int,Int>){
        progressBar.progress = 0
        if(map.isNotEmpty()){
           setData(map)
        }
        loading.visibility = View.INVISIBLE
    }

    override fun updateProgress(progress: Int, max: Int) {
        progressBar.max = max
        progressBar.progress = progress
        //println("${progress}/$max")
    }

    private fun setData(map: Map<Int,Int>){
        var left = ""
        var right = ""
        map.forEach { (t, u) ->
            left += "$t\n"
            right += "$u\n"
        }
        calcButton.setText(R.string.calculate)
        left += "1"
        leftText.text = left
        rightText.text = right
    }
}