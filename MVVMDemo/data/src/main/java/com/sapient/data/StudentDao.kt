package com.sapient.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDao {

    @Insert
    suspend fun addStudent(std: Student)

    @Delete
    suspend fun deleteStudent(std: Student)

    @Update
    suspend fun updateMarks(std: Student)

    @Query("select * from student")
    fun getAllStudents(): LiveData<List<Student>>

    @Query("select * from student where marks < :cutoff")
    suspend fun getFailedStudents(cutoff: Int): List<Student>

}