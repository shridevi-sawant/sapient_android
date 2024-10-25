package com.paypal.unittesingdemo.model

class Calculator(val utility: MathUtility) {

    fun doOperation(a: Int, b: Int, type: Int) : Int{
        return when(type){
            1 -> utility.add(a, b)

            else -> {
                utility.subtract(a,b)
            }
        }
    }

}