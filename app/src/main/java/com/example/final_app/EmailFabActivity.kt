package com.example.final_app

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View

class EmailFabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_fab)
        val emailFab = findViewById<View>(R.id.email_fab)

        emailFab.setOnClickListener {
            val hodEmail = resources.getString(R.string.hod_email)

            // Create an intent to send an email
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$hodEmail")
            }

            // Launch the email app
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}