package com.sapient.composedemo

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val TAG = "MainActivity"

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {


    val sbarHostState =  LocalSnackBarHostState.current

    val ctx = LocalContext.current


    var showDlg by remember {
        mutableStateOf(false)
    }

    var userid by remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        // fetching data

        launch(Dispatchers.Default) {
            Log.d(TAG, "LoginScreen: fetching data")
        }
    }




    if (showDlg){


        ConfirmationDlg(msg = "Logging in $userid", okHandler = {
            showDlg = false
        },
            cancelHandler = {
            showDlg = false
                userid = ""
        })
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.primaryContainer)) {

        Text("Welcome to Sapient")

        Image(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow, shape = RoundedCornerShape(20.dp)),
            imageVector = Icons.Filled.AccountBox,
            contentDescription = "logo")

        Text(text = "Login Credentials",
            style = MaterialTheme.typography.headlineLarge)

        OutlinedTextField(
            singleLine = true,
            placeholder = {
                Text(text = "Registered Email")
            },
            value = userid, onValueChange = {
            Log.d(TAG, "LoginScreen: new userid $it")
            userid = it
        })

        OutlinedButton(onClick = {

            scope.launch {
                sbarHostState.showSnackbar("Logging in")
            }

//            val i = Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234"))
//            ctx.startActivity(i)
              //  showDlg = true
//            Toast.makeText(ctx, "Logging in $userid",
//                Toast.LENGTH_LONG).show()
        }) {
            Text(text = "Login")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewLogin() {
    LoginScreen()
}
