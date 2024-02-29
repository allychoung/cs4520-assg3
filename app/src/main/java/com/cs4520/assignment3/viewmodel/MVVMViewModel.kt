package com.cs4520.assignment3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cs4520.assignment3.data.Operation
import com.cs4520.assignment3.model.CalculatorModel

class MVVMViewModel() : ViewModel() {
    private val model = CalculatorModel()

    private var liveInput1 = MutableLiveData<Number>()
    private var liveInput2 = MutableLiveData<Number>()
    private var calcResult = MutableLiveData<Number>()

    fun getResult(op : Operation): Number {
//        TODO
        return 1
    }

}