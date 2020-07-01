package com.hrandika.angular.onedu.course.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hrandika.angular.onedu.R
//asss
class SearchCourseFragment : Fragment(){

    private lateinit var viewModel: SearchCourseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(SearchCourseViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_search_course, container, false)
        val textView: TextView = root.findViewById(R.id.search_text)
        viewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }

}