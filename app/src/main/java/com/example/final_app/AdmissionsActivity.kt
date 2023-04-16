package com.example.final_app

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AdmissionsActivity : AppCompatActivity() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions)

        val uccApplicationLink = "https://www.ucc.edu.jm/apply/"

        // Initialize the admission requirements TextView
        val admissionRequirementsTextView = findViewById<TextView>(R.id.admissionRequirementsTextView)
        admissionRequirementsTextView.text = "Admission Requirements:\n  \n 1. Individuals should possess a minimum of five (5) subjects at the GCE or CSEC level (including the mandatory English Language and Mathematics) at grades A, B, C or 1, 2, 3 respectively. A CSEC pass at level 3 must have been obtained since 1998.\n" +
                "\n 2. Candidates who have a minimum of 4 CXCs can also apply pending the outstanding CXC subjects or can opt to do UCC replacement courses Core Mathematics, English for Academic Purpose and Fundamentals of Accounting."
                "\n 3. Candidates can opt to apply under the Mature Entry option. To be accepted, applicants must be working for 5 years or more and be at a minimum age of 25 years. Academic qualifications, a detailed resume, a job letter and 3 professional references will be required."

        // Initialize the apply button
        val applyButton = findViewById<Button>(R.id.applyButton)
        applyButton.setOnClickListener {
            // Open the UCC application page in a web browser
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uccApplicationLink))
            startActivity(browserIntent)
        }
    }
}
