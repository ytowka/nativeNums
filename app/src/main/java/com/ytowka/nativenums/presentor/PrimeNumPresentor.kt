package com.ytowka.nativenums.presentor

import com.ytowka.nativenums.model.PrimeNumCalc
import com.ytowka.nativenums.views.PrimeNumFragInterface
import kotlinx.coroutines.*

class PrimeNumPresentor {
    var fragmentInterface: PrimeNumFragInterface? = null

    var result: Map<Int,Int>? = null
    val calculator: PrimeNumCalc by lazy { PrimeNumCalc() }
    fun calculate(num: Int){
        CoroutineScope(Dispatchers.Default).launch{
            result = null
            launch {
                while (isActive){
                    delay(50)
                    fragmentInterface!!.updateProgress(calculator.progress,calculator.total)
                }
            }
            val calculation: Map<Int, Int> = calculator.calculate(num) {
                if (!isActive) {
                    calculator.stop()
                }
            }
            withContext(Dispatchers.Main) {
                result = calculation
                if(fragmentInterface != null) fragmentInterface!!.onCalculationEnd(calculation)
            }
        }
    }
    fun stop(){
        calculator.stop();
        if(fragmentInterface != null) fragmentInterface!!.onCalculationEnd(result?: mapOf() )
    }
}