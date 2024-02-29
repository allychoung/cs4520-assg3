package com.cs4520.assignment3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cs4520.assignment3.data.Operation
import com.cs4520.assignment3.model.CalculatorModel

class MVVMViewModel() : ViewModel() {
    private val model = CalculatorModel()

    public var result = MutableLiveData<Number>()

    fun calculate(op : Operation, input1: String, input2: String) {
         result.value = model.updateResult(input1.toFloat(), input2.toFloat(), op)
    }

}