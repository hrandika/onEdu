package com.hrandika.angular.onedu.course.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hrandika.angular.onedu.R


class CourseFragment : Fragment() {

    private lateinit var viewModel: CourseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_course, container, false)
        viewModel = ViewModelProvider(this).get(CourseViewModel::class.java)

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = CourseListAdapter(root.context)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(root.context)

        viewModel.allCourses.observe(viewLifecycleOwner, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.setCoursers(it) }
        })
        println("hello course created")

        return root
    }


}