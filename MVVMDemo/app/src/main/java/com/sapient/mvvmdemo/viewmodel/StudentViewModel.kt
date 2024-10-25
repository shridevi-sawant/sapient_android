package com.sapient.mvvmdemo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sapient.data.Student
import com.sapient.data.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// reference to repository
// no referene to view
// hold observable data required by view
class StudentViewModel(application: Application) : AndroidViewModel(application) {

    val isStdAdded = MutableLiveData<Boolean>(false)
    //val stdList = MutableLiveData<List<Student>>()

    private val repo = com.sapient.data.StudentRepository(application)

    fun addNewStudent(name: String, rNo: String, marks: String){
        viewModelScope.launch(Dispatchers.Default) {
            if(repo.addNewStudent(name,
                    rNo.toIntOrNull()?: 1,
                    marks.toIntOrNull() ?: 100)){
                isStdAdded.postValue(true)
            }
            else {
                isStdAdded.postValue(false)
            }
        }
    }

    fun fetchStudentList(): LiveData<List<com.sapient.data.Student>>{
        return repo.getStudents()
    }


}