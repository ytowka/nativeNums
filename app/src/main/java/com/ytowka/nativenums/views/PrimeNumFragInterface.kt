package com.ytowka.nativenums.views

interface PrimeNumFragInterface {
    fun onCalculationEnd(map: Map<Int,Int>)
    fun updateProgress(progress: Int, max: Int)
}