package com.ytowka.nativenums.presentor

import android.app.Application
import com.google.android.material.textfield.TextInputEditText

class App : Application() {
    lateinit var pmPresentor: PrimeNumPresentor
    private set
    lateinit var nodPresentor: NodPresentor
    private set

    override fun onCreate() {
        super.onCreate()
        pmPresentor = PrimeNumPresentor()
        nodPresentor = NodPresentor()
    }
    companion object{
        fun TextInputEditText.int(): Int {
            when (text.toString()) {
                "" -> return 0
                else -> return text.toString().toInt()
            }
        }
    }
}
