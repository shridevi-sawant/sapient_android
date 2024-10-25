package com.sapient.mvvmdemo.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.sapient.mvvmdemo.viewmodel.StudentViewModel


// reference to viewModel
@Composable
fun AddStudentScreen(modifier: Modifier = Modifier) {
    val ctx = LocalContext.current

    val owner = LocalViewModelStoreOwner.current
    val vModel = ViewModelProvider(owner!!).get(StudentViewModel::class)

    val isAdded = vModel.isStdAdded.observeAsState()

    var name by remember {
        mutableStateOf("")
    }
    var rNo by remember {
        mutableStateOf("")
    }
    var marks by remember {
        mutableStateOf("")
    }



    Column(modifier = modifier
        .fillMaxSize()
        .background(Color.Cyan)
        .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Add New Student")
        OutlinedTextField(value = name,
            label = {
                Text("Student Name")
            },
            onValueChange = {
            name = it
        })

        OutlinedTextField(value = rNo,
            label = {
                Text("Roll Number")
            },
            onValueChange = {
                rNo = it
            })

        OutlinedTextField(value = marks,
            label = {
                Text("Marks")
            },
            onValueChange = {
                marks = it
            })

        Button(onClick = {
            vModel.addNewStudent(name, rNo, marks)

        }) {
            Text(text = " ADD ")
        }

        if (isAdded.value == true){
            Toast.makeText(ctx, "Added", Toast.LENGTH_LONG).show()
        }

    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewAdd() {
    AddStudentScreen()
}