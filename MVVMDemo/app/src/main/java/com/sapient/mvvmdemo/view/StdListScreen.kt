package com.sapient.mvvmdemo.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.sapient.data.Student
import com.sapient.mvvmdemo.viewmodel.StudentViewModel


@Composable
fun StudentListScreen(modifier: Modifier = Modifier) {

    val ctx = LocalContext.current
    val owner = LocalViewModelStoreOwner.current
    val vModel = ViewModelProvider(owner!!).get(StudentViewModel::class)

    val stdList = vModel.fetchStudentList().observeAsState()

    //vModel.fetchStudentList()

    Scaffold(

        floatingActionButton = {
            Surface(shape = RoundedCornerShape(10.dp),
                border = BorderStroke(2.dp, Color.Magenta)) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add student"
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Yellow)
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val count =  stdList.value?.count() ?: 0
            Text(text = "Student Count: $count")
            if (count > 0) {
                LazyColumn {
                    items(stdList.value!!){
                        StudentItem(std = it)
                    }
                }
            }
        }
    }

}

@Composable
fun StudentItem(std: com.sapient.data.Student) {
    Card(
        modifier = Modifier.fillMaxSize(),
        colors = CardDefaults.cardColors(containerColor = Color.Green),
        border = BorderStroke(2.dp, color = Color.Blue)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = std.name)
            Text(text = "${std.rollNo}")
            Text(text = "${std.marks} %")
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewStd() {
    StudentListScreen()
}