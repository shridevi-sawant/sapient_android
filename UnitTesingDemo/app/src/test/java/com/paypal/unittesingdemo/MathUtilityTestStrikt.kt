package com.paypal.unittesingdemo

import com.paypal.unittesingdemo.model.MathUtility
import org.junit.Before
import org.junit.Test
import strikt.api.expect
import strikt.assertions.isEqualTo
import strikt.assertions.isNotNull

class MathUtilityTestStrikt {
    lateinit var utility: MathUtility

    @Before
    fun setup(){
        utility = MathUtility()
    }

    @Test
    fun testDivide(){
        // with
        val arg1 = 10
        val arg2 = 2

        //perform
        val actualResult = utility.divide(arg1, arg2)

        //verify
        expect {
            that(actualResult).isEqualTo(5)
            that(actualResult).isNotNull()
        }
    }
}