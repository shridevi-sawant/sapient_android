package com.sapient.data

import android.content.Context
import androidx.lifecycle.LiveData

class StudentRepository(ctx: Context) {

    // data sources - Room / webservice
    val stdDao = StudentDatabase.getInstance(ctx).getDao()

    fun getStudents(): LiveData<List<Student>> {
        return stdDao.getAllStudents()
    }

    suspend fun addNewStudent(name: String, id: Int, marks: Int) : Boolean{
        return try {
            stdDao.addStudent(Student(id, name, marks))
             true
        }catch (err: Exception) {
            false
        }
    }

    suspend fun deleteStudent(student: Student){
        stdDao.deleteStudent(student)
    }

    suspend fun updateMarks(student: Student, newMarks: Int){
        student.marks = newMarks
        stdDao.updateMarks(student)
    }
}