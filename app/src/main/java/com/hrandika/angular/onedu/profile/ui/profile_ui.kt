package com.hrandika.angular.onedu.profile.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hrandika.angular.onedu.R

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
        // TODO: Use the ViewModel
    }

}