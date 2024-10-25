package com.sapient.composedemo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class Student(val rollNo: Int, var name: String, var marks: Int)

val stdList = listOf(Student(1, "john", 23),
    Student(2, "john2", 23),
    Student(3, "john3", 23),
    Student(4, "john4", 23),
    Student(5, "john5", 23),
    Student(6, "john6", 23),
    Student(7, "john2", 23),
    Student(8, "john3", 23),
    Student(9, "john4", 23),
    Student(10, "john5", 23),
    Student(11, "john6", 23),
    )

@Composable
fun StudentScreen(modifier: Modifier = Modifier) {
    
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(stdList, key = {
            it.rollNo
        }){
            
            StudentItem(it)
        }
    }
}

@Composable
fun StudentItem(std: Student) {
    
    ElevatedCard(
        colors = CardDefaults.elevatedCardColors(containerColor = Color.Cyan),
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 5.dp),
        onClick = {  }) {
        Column {
            Text(text = std.name)
            Text(text = "Roll: ${std.rollNo}")
            Text(text = "Marks: ${std.marks}")
        }
    }
}
