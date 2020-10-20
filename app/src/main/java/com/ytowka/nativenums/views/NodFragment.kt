package com.ytowka.nativenums.views
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ytowka.nativenums.presentor.App.Companion.int
import com.ytowka.nativenums.model.Named
import com.ytowka.nativenums.R
import kotlinx.android.synthetic.main.fragment_nn.*

class NodFragment(override var name: String) : Fragment(), Named, NodFragmentInterface {
    constructor() : this("dum")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_nn, container, false)
    }

    override fun onStart() {
        super.onStart()
        val presenter = (activity as MainActivity).app.nodPresentor
        presenter.fragmentInterface = this

        if (presenter.result != null){
            val (g,l) = presenter.result!!
            lcmgcdText.text = "${getString(R.string.GCD)} = $g \n${getString(R.string.LCM)} = $l"
        }
        calcnod.setOnClickListener {
            val a = if (numA.int() != 0) numA.int() else 1
            val b = if (numB.int() != 0) numB.int() else 1
            presenter.calculate(a,b)
        }
    }
    override fun onCalculationEnd(a: Long,b:Long){
        lcmgcdText.text = "${getString(R.string.GCD)} = $a \n${getString(R.string.LCM)} = $b"
    }
}