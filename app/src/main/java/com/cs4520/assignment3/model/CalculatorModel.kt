package com.cs4520.assignment3.model

import com.cs4520.assignment3.data.Operation

class CalculatorModel {
    fun calculate(i1: Float, i2: Float, op: Operation): Number {
        if (i2.isNaN() || i1.isNaN()) {
            throw NumberFormatException()
        }

        when (op) {
            Operation.ADD -> return i1 + i2
            Operation.SUB -> return i1 - i2
            Operation.MUL -> return i1 * i2
            Operation.DIV -> if (i2.equals(0.0f)) {
                throw ArithmeticException("Divisor cannot be 0. Try again.")
            } else {
                return i1 / i2
            }
        }
    }
}