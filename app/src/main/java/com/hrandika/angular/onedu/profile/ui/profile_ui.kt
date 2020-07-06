package com.hrandika.angular.onedu.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hrandika.angular.onedu.R
import com.hrandika.angular.onedu.profile.data.ProfileInfo
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.profile_ui_fragment.*

class profile_ui : Fragment() {

    companion object {
        fun newInstance() = profile_ui()
    }

    private lateinit var viewModel: ProfileUiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_ui_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfileUiViewModel::class.java)

        viewModel.profileInfo.observe(viewLifecycleOwner, Observer { words: ProfileInfo ->
            words?.let {
                profileName.text = words.name
                Picasso.get().load(words.profileImage)
                    .error(R.drawable.ic_menu_camera)
                    .transform(CropCircleTransformation())
                    .into(imageView2)
                profileDescription.text = words.description
                completedCount.text = words.completedCourses.toString()
                inProgressCount.text = words.inProgressCourse.toString()
                savedCount.text = words.savedCourse.toString()
            }
        })
    }

}