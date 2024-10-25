package com.sapient.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Student(
    @PrimaryKey val rollNo: Int,
    var name: String,
    var marks: Int)
