package com.cs4520.assignment3

import android.util.Log
import com.cs4520.assignment3.data.Operation
import com.cs4520.assignment3.model.CalculatorModel
import java.lang.NumberFormatException

class CalculatorPresenter(override val model: CalculatorModel,
                          override val view: MVPContract.View
) : MVPContract.Presenter {
    override fun onButtonClick(op: Operation, input1: String, input2: String) {
        var res: Number? = null

        try {
            Log.i("tofloat", input1.toFloat().toString())
            validateInput(input1)
            validateInput(input2)
            res = model.updateResult(input1.toFloat(), input2.toFloat(), op)
        } catch (e: Exception) {
            e.message?.let { view.displayErrorMessage(it) }
        }

        view.setResult(res)
        view.clearInputFields()
    }

    private fun validateInput(input: String): Boolean {
        return input.toFloat().isFinite();
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

}