package com.hrandika.angular.onedu.course.data

import androidx.lifecycle.LiveData

class CourseRepository(private val courseDao: CourseDao) {
    val allCourses: LiveData<List<Course>> = courseDao.getAll()

    suspend fun insert(course: Course) {
        courseDao.insertAll(course)
    }
}