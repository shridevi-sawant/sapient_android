package com.paypal.unittesingdemo.model

class MathUtility {

    fun add(a: Int, b:Int ) = a + b

    fun subtract(a: Int, b:Int) : Int {
        return a - b
    }

    fun multiply(a: Int, b:Int) : Int {
        return a * b
    }

    fun divide(a: Int, b:Int) : Int? {
        if (b == 0) return null

        return a / b
    }

}