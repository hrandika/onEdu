package com.hrandika.angular.onedu.profile.data

class ProfileInfo(val name: String,
                  val profileImage: String,
                  val description: String,
                  val completedCourses: Int,
                  val inProgressCourse: Int,
                  val savedCourse: Int,
                  val myCourses: List<courses>) {
}