package com.cs4520.assignment3.model

import com.cs4520.assignment3.data.Operation

data class Calculator(val result: Number)

class CalculatorModel {
    fun updateResult(i1: Float, i2: Float, op: Operation): Number {
        if (i2.isNaN() || i1.isNaN()) {
            throw IllegalArgumentException("Invalid user input. Try again.")
        }

        when (op) {
            Operation.ADD -> return i1 + i2
            Operation.SUB -> return i1 - i2
            Operation.MUL -> return i1 * i2
            Operation.DIV -> if (i2.equals(0.0f)) {
                throw IllegalArgumentException("Divisor cannot be 0. Try again.")
            } else {
                return i1 / i2
            }
        }
    }
}