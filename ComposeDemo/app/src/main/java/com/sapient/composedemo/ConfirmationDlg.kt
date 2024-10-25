package com.sapient.composedemo

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ConfirmationDlg(msg: String,
                    cancelHandler: () -> Unit,
                    okHandler: () -> Unit,
                    modifier: Modifier = Modifier) {


    AlertDialog(
        title = {
            Text(text = "Confirmation")
        },
        text = {
            Text(text = msg)
        },
        onDismissRequest = {
            cancelHandler()
    },
        dismissButton = {
            Button(onClick = {
                cancelHandler()
            }) {
                Text("Cancel")
            }
        },
        confirmButton = {
        Button(onClick = {
            okHandler()
        }) {
            Text("OK")
        }
    })
}