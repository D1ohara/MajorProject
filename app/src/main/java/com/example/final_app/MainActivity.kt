package com.example.final_app

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val facebookWebView = findViewById<WebView>(R.id.facebook_web_view)
        val twitterWebView = findViewById<WebView>(R.id.twitter_web_view)
        val instagramWebView = findViewById<WebView>(R.id.instagram_web_view)

        val facultyStaffButton = findViewById<CardView>(R.id.facultyStaffButton)
        facultyStaffButton.setOnClickListener {
            val intent = Intent(this, FacultyStaffActivity::class.java)
            startActivity(intent)
        }

        val coursesButton = findViewById<CardView>(R.id.coursesButton)
        coursesButton.setOnClickListener {
            val intent = Intent(this, CourseActivity::class.java)
            startActivity(intent)
        }

        val admissionsButton = findViewById<CardView>(R.id.admissionsButton)
        admissionsButton.setOnClickListener {
            val intent = Intent(this, AdmissionsActivity::class.java)
            startActivity(intent)
        }

        val socialMediaButton = findViewById<CardView>(R.id.socialMediaButton)
        socialMediaButton.setOnClickListener {
            val intent = Intent(this, SocialMediaActivity::class.java)
            startActivity(intent)
        }

        val emailFab = findViewById<FloatingActionButton>(R.id.emailFab)
        emailFab.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("ithod@ucc.edu.jm"))
            startActivity(Intent.createChooser(intent, "Send email"))
        }
    }
}
