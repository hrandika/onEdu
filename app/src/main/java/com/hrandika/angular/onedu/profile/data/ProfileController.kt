package com.hrandika.angular.onedu.profile.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class ProfileController {
    val profileInfo: MutableLiveData<ProfileInfo> = MutableLiveData<ProfileInfo>();

    fun getProfileDetaisl(): LiveData<ProfileInfo> {
        //TODO load data from firebase
        profileInfo.postValue(ProfileInfo(
            "profile name from controller",
            "https://firebasestorage.googleapis.com/v0/b/personasite-a11de.appspot.com/o/IMG_20200702_165116.jpg?alt=media&token=d979a4eb-bdb2-42e1-9d1b-48b67f249241",
            "this is the desption from controller ",
            12,
            3,
            5
            ));
        return profileInfo;
    }
}