package com.example.final_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CourseActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var courseList: ArrayList<Course>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        courseList = ArrayList()
        courseList.add(Course("ITT101", "Computer Information System", 3, "None", "An introduction to Information Technology"))
        courseList.add(Course("ITT116 ", "Computer Essentials & Troubleshooting I", 3, "ITT101 Computer Information Systems", "An in-depth study of Computer Troubleshooting"))
        courseList.add(Course("ITT103", "Programming Techniques ", 3, "ITT101 Computer Information Systems", "An overview of Python Coding."))
        courseList.add(Course("ITT102", "Discrete Mathematics I ", 3, "None", "The study of mathematical structures that can be considered discrete rather than continuous"))
        courseList.add(Course("ITT208 ", "Internet Authoring I ", 3, "ITT103 Programming Techniques ", "An introduction to websites and internet manipulation"))
        courseList.add(Course("ITT200 ", "Object Oriented Programming using C++", 3, "ITT103 Programming Techniques", "Computer programming model that organizes software design around data, or objects, rather than functions and logic."))
        courseList.add(Course("ITT211 ", "Computer Data Analysis", 3, "None", "The process of examining data sets in order to find trends and draw conclusions about the information they contain."))
        courseList.add(Course("ITT203 ", "Data Structures and File Mgt. I ", 3, "ITT200 Object Oriented Programming using C++", "Organizing, processing, retrieving and storing data"))
        courseList.add(Course("ITT201 ", "Data Communication & Networks I", 3, "ITT101 Computer Information Systems", "The transmission of digital data between two or more computers and a computer network or data network is a telecommunications network that allows computers to exchange data."))
        courseList.add(Course("ITT215", "Technical Writing for Digital Media", 3, "ENG109 Academic Writing I", "Writing or drafting technical communication used in technical and occupational fields, such as computer hardware and software, architecture, engineering, chemistry, aeronautics, robotics, finance, medical, consumer electronics, biotechnology, and forestry."))

        val adapter = CourseAdapter(courseList)
        recyclerView.adapter = adapter
    }
}
