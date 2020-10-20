package com.ytowka.nativenums.model

class LcmCalc{
    private fun gcd(a: Long, b: Long): Long {
        var ans: Long = a
        if (b != 0L){
            if (!stopFlag) ans = gcd(b, a % b)
            else isCalculating = false
        }
        isCalculating = false
        return ans
    }
    private fun lcm(a: Long, b: Long,gcd: Long? = null): Long {
        if(gcd != null){
            return a / gcd * b
        }
        return a / gcd(a, b) * b
    }
    private var isCalculating = false
    fun isCalculating(): Boolean {
        return isCalculating
    }
    private var stopFlag = false
    fun stop() {
        if(isCalculating) stopFlag = true
    }
    fun calculate(a: Int, b: Int): Answer{
        val gcd = gcd(a.toLong(),b.toLong())
        return Answer(gcd,lcm(a.toLong(),b.toLong(),gcd))
    }
    data class Answer(val gcd: Long,val lcm: Long)
}