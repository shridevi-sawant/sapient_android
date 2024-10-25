package com.paypal.unittesingdemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    var name by remember {
        mutableStateOf("")
    }

    var welcomeMsg by remember {
        mutableStateOf("Welcome")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = welcomeMsg,
            fontSize = 24.sp,
            color = Color.White
        )

        OutlinedTextField(
            modifier = Modifier.testTag("name"),
            colors = TextFieldDefaults.colors(focusedContainerColor = Color.White),
            label = {
                Text(text = "Full Name")
            },
            value = name, onValueChange = {
            name = it
        } )

        Button(onClick = {
            welcomeMsg = "Welcome $name"
        }) {
            Text(text = "Continue", fontSize = 24.sp)
        }

    }
}

@Preview
@Composable
private fun PreviewHome() {
    HomeScreen()
}