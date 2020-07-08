package com.hrandika.angular.onedu.profile.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hrandika.angular.onedu.R
import com.hrandika.angular.onedu.profile.data.courses
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import jp.wasabeef.picasso.transformations.CropSquareTransformation
import kotlinx.android.synthetic.main.fragment_course_item_profile.view.*
import kotlinx.android.synthetic.main.profile_ui_fragment.*

class ProfileCourseAdapter internal constructor(context: Context): RecyclerView.Adapter<ProfileCourseAdapter.CourseViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var courses= emptyList<courses>() // Cached copy of words

    inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.content)
        val imageView: ImageView = itemView.findViewById(R.id.imageView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemView = inflater.inflate(R.layout.fragment_course_item_profile, parent, false)
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val current = courses[position]
        holder.wordItemView.text = current.title
        Picasso.get().load(current.courseImage)
            .error(R.drawable.ic_menu_camera)
            .transform(CropSquareTransformation())
            .into(holder.imageView)
    }

    internal fun setCoursers(courses: List<courses>) {
        this.courses = courses
        notifyDataSetChanged()
    }

    override fun getItemCount() = courses.size
}