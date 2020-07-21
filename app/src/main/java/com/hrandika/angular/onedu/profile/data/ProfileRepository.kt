package com.hrandika.angular.onedu.profile.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hrandika.angular.onedu.course.data.Course

class ProfileRepository(private val profileController: ProfileController) {
    val profileInfo: LiveData<ProfileInfo> = profileController.getProfileDetaisl();

    fun requestData(): LiveData<ProfileInfo>{
        return profileController.getProfileDetaisl();
    }

}