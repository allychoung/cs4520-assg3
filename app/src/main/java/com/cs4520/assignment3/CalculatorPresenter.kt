package com.cs4520.assignment3

import com.cs4520.assignment3.data.Operation
import com.cs4520.assignment3.model.CalculatorModel
import java.lang.NumberFormatException

class CalculatorPresenter(override val model: CalculatorModel,
                          override val view: MVPContract.View
) : MVPContract.Presenter {
    override fun onButtonClick(op: Operation, input1: String, input2: String) {
        var res: Number? = null

        try {
            res = model.updateResult(input1.toFloat(), input2.toFloat(), op)
        } catch (e: IllegalArgumentException) {
            e.message?.let { view.displayErrorMessage(it) }
        }

        view.setResult(res)
        view.clearInputFields()
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

}