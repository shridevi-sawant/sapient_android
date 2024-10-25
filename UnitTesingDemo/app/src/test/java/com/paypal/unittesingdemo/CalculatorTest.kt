package com.paypal.unittesingdemo

import com.paypal.unittesingdemo.model.Calculator
import com.paypal.unittesingdemo.model.MathUtility
import io.mockk.called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    lateinit var mockedUtility: MathUtility
    lateinit var calc: Calculator

    @Before
    fun setup(){
        mockedUtility = mockk<MathUtility>()
        calc = Calculator(mockedUtility)
    }

    @Test
    fun testAdd(){

        val arg1 = 10
        val arg2 = 20
        val type = 1

        every { mockedUtility.add(arg1, arg2) } returns 30
        every { mockedUtility.subtract(arg1, arg2) } returns -10

        // perform
        calc.doOperation(arg1, arg2, type)

        // verification

        verify(exactly = 1) {
            mockedUtility.add(arg1, arg2)
        }
        verify(exactly = 0) {
            mockedUtility.subtract(any(), any())
        }
    }
}