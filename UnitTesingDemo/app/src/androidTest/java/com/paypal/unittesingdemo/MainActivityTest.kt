package com.paypal.unittesingdemo

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performKeyInput
import androidx.compose.ui.test.performKeyPress
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.pressKey
import androidx.test.core.graphics.writeToTestStorage
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    @get: Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testLayout(){

        rule.onNodeWithText("Welcome")
            .assertIsDisplayed()

        rule.onNodeWithTag("name")
            .assertIsDisplayed()

        rule.onNodeWithTag("name")
            .assertTextContains("")

        rule.onNodeWithText("Continue")
            .assertIsDisplayed()

        rule.onNodeWithText("Continue")
            .assertIsEnabled()

        // taking snapshot
        val bmp = rule.onRoot().captureToImage().asAndroidBitmap()

        val fileOS = rule.activity.openFileOutput("firstScreen.png",
            Context.MODE_PRIVATE)

        bmp.compress(Bitmap.CompressFormat.PNG, 100, fileOS)

        fileOS.close()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testBtnClick(){

        rule.onNodeWithTag("name")
            .performTextInput("demo")

        rule.onNodeWithText("Continue")
            .performClick()

        rule.onNodeWithText("Welcome demo")
            .assertIsDisplayed()
    }
}