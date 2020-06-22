package com.hrandika.angular.onedu.course.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hrandika.angular.onedu.R
import com.hrandika.angular.onedu.course.data.Course

class CourseListAdapter internal constructor(context: Context): RecyclerView.Adapter<CourseListAdapter.CourseViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var courses= emptyList<Course>() // Cached copy of words

    inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val current = courses[position]
        holder.wordItemView.text = current.name
    }

    internal fun setCoursers(courses: List<Course>) {
        this.courses = courses
        notifyDataSetChanged()
    }

    override fun getItemCount() = courses.size
}