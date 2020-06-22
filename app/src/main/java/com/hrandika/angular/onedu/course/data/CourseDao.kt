package com.hrandika.angular.onedu.course.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CourseDao {

    @Query("SELECT * FROM course")
    fun getAll(): LiveData<List<Course>>

    @Insert
    fun insertAll(vararg courses: Course)

    @Query("DELETE FROM course")
    fun deleteAll()

}