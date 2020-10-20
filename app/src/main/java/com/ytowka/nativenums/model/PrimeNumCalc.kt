package com.ytowka.nativenums.model

import com.ytowka.nativenums.views.MainActivity

class PrimeNumCalc{
    private var isCalclating = false
    private var stopFlag = false

    var total = 0
    private set
    var progress = 0
    private set

    fun calculate(num: Int,onLoop: ()->Unit): Map<Int,Int> {
        isCalclating = true;
        val res = mutableMapOf<Int, Int>()
        if (num == 0){
            isCalclating = false;
            return (mapOf(0 to 0))
        }
        var left: Int = num
        var currentDivid = 2
        var bufferLeft: Int

        while (left != 1) {
            bufferLeft = left
            total = left
            while (left % currentDivid != 0) {
                onLoop()
                if(stopFlag){
                    MainActivity.printd("stop")
                    stopFlag = false;
                    isCalclating = false
                    return mapOf()
                }
                if (currentDivid > 2) currentDivid++
                currentDivid++
                progress = currentDivid
            }
            left /= currentDivid
            res[bufferLeft] = currentDivid
            println("left num: $left")
        }
        isCalclating = false
        return res
    }

    fun isCalculating(): Boolean {
        return isCalclating
    }
    fun stop(){
        if(isCalclating) stopFlag = true
    }
}