package com.paypal.unittesingdemo

import com.paypal.unittesingdemo.model.MathUtility
import org.junit.Assert.assertEquals

import org.junit.Assert.assertNull
import org.junit.Test

class MathUtilityTest {

    @Test
    fun testAdd(){
        // with - data
        val arg1 = 10
        val arg2 = 20

        // perform test
        val utility = MathUtility()
        val actualResult = utility.add(arg1, arg2)

        // verify
        assertEquals(30, actualResult)
    }

    @Test
    fun testSubtract(){
        // with - data
        val arg1 = 10
        val arg2 = 20

        // perform test
        val utility = MathUtility()
        val actualResult = utility.subtract(arg1, arg2)

        // verify
        assertEquals(-10, actualResult)
    }

    @Test
    fun testDivide(){
        // with - data
        val arg1 = 10
        val arg2 = 2

        // perform test
        val utility = MathUtility()
        val actualResult = utility.divide(arg1, arg2)

        // verify
        assertEquals("10 divided by 2 is 5", 5, actualResult)
    }

    // test description - division by zero result should be null
    @Test
    fun testDivideByZero(){
        // with - data
        val arg1 = 10
        val arg2 = 0

        // perform test
        val utility = MathUtility()
        val actualResult = utility.divide(arg1, arg2)

        // verify
        assertNull(actualResult)
    }
}