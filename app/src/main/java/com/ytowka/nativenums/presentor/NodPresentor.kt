package com.ytowka.nativenums.presentor

import com.ytowka.nativenums.model.LcmCalc
import com.ytowka.nativenums.views.NodFragmentInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NodPresentor {
    var fragmentInterface: NodFragmentInterface? = null

    var result: LcmCalc.Answer? = null
    val calculator: LcmCalc by lazy { LcmCalc() }
    fun calculate(a: Int,b: Int,){
        result = null
        GlobalScope.launch {
            val calculation =  calculator.calculate(a,b);
            result = calculation
            val (g,l) = calculation
            withContext(Dispatchers.Main){
                fragmentInterface!!.onCalculationEnd(g,l)
            }
        }
    }

}