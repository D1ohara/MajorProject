package com.example.final_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter(private val courses: List<Course>) :
    RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    // This class is used to hold references to views used in the RecyclerView item layout
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseCode: TextView = itemView.findViewById(R.id.course_code)
        val courseName: TextView = itemView.findViewById(R.id.course_name)
        val courseCredits: TextView = itemView.findViewById(R.id.course_credits)
        val coursePrerequisites: TextView = itemView.findViewById(R.id.course_prerequisites)
        val courseDescription: TextView = itemView.findViewById(R.id.course_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = courses[position]
        holder.courseCode.text = course.code
        holder.courseName.text = course.name
        holder.courseCredits.text = course.credits.toString()
        holder.coursePrerequisites.text = course.prerequisites
        holder.courseDescription.text = course.description
    }

    override fun getItemCount() = courses.size
}
