package com.sapient.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Student::class), version = 1)
abstract class StudentDatabase: RoomDatabase() {

    abstract fun getDao() : StudentDao

    companion object{
        private var instance: StudentDatabase? = null

        fun getInstance(ctx: Context): StudentDatabase {
            return instance ?: createDB(ctx.applicationContext).also {
                instance = it
            }
        }

        private fun createDB(ctx: Context): StudentDatabase {

            return Room.databaseBuilder(ctx,
                StudentDatabase::class.java,
                "students.db").build()
        }
    }

}