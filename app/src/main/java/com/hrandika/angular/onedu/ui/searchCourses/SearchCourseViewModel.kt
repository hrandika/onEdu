package com.hrandika.angular.onedu.course.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hrandika.angular.onedu.course.data.Course
import com.hrandika.angular.onedu.course.data.CourseRepository
import com.hrandika.angular.onedu.utils.database.OneduRoomDatabase
import androidx.lifecycle.viewModelScope

public class SearchCourseViewModel(application:Application): AndroidViewModel(application) {

    private val repository:CourseRepository

    val allCourses:LiveData<List<Course>>
    private val _text = MutableLiveData<String>().apply {
        value = "Search"
    }
    val text: LiveData<String> = _text

    init {
        val couseDoa = OneduRoomDatabase.getDatabase(application,viewModelScope).courseDao()
        repository = CourseRepository(couseDoa)
        allCourses = repository.allCourses
    }

}