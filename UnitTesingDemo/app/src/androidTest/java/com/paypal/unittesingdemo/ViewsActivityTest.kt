package com.paypal.unittesingdemo


import android.view.View
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class ViewsActivityTest {

    @get:Rule
    val rule = ActivityScenarioRule(ViewsActivity::class.java)

    @Test
    fun testLayout(){


            onView(withId(R.id.msgT)).check(matches(isDisplayed()))

            onView(withText("Continue")).check(matches(isEnabled()))

            onView(withId(R.id.nameE)).check(matches(isDisplayed()))

    }

    @Test
    fun testButtonClick(){
        onView(withId(R.id.nameE))
            .perform(ViewActions.clearText())
            .perform(ViewActions.typeText("admin"))

        closeSoftKeyboard()

        onView(withText("Continue"))
            .perform(ViewActions.click())

        onView(withId(R.id.msgT)).check(matches(withText("Welcome admin")))
    }
}