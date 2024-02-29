package com.cs4520.assignment3

import com.cs4520.assignment3.data.Operation
import com.cs4520.assignment3.model.CalculatorModel

/**
 * Establishes abstractions for View, Model, and Presenter
 * classes in implementations of the MVP architecture pattern
 */
public interface MVPContract {
    interface View {
        /**
         * Displays an error message in case of invalid inputs
         */
        fun displayErrorMessage(msg: String);

        /**
         * Sets the result text field of the view
         */
        fun setResult(res: Number?);

        /**
         * Clears the text input fields of the view
         */
        fun clearInputFields();
    }

    interface Presenter {
        val view: View
        val model: CalculatorModel

        /**
         * Handles a button click event
         */
        fun onButtonClick(op: Operation, input1: String, input2: String);
    }
}