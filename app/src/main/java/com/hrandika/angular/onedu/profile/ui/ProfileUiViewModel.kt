package com.hrandika.angular.onedu.profile.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hrandika.angular.onedu.profile.data.ProfileController
import com.hrandika.angular.onedu.profile.data.ProfileInfo
import com.hrandika.angular.onedu.profile.data.ProfileRepository

class ProfileUiViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val repository: ProfileRepository

    val profileInfo: LiveData<ProfileInfo>;

    init {
        val controller = ProfileController();
        repository = ProfileRepository(controller)
        profileInfo = repository.requestData();
    }
}