package com.example.final_app

import android.os.Bundle
import android.webkit.WebView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SocialMediaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_media)

        val facebookWebView = findViewById<WebView>(R.id.facebook_web_view)
        facebookWebView.settings.javaScriptEnabled = true

        val twitterWebView = findViewById<WebView>(R.id.twitter_web_view)
        twitterWebView.settings.javaScriptEnabled = true

        val instagramWebView = findViewById<WebView>(R.id.instagram_web_view)
        instagramWebView.settings.javaScriptEnabled = true

        // Set on click listener for Facebook icon
        val facebookIcon = findViewById<ImageView>(R.id.facebook_icon)
        facebookIcon.setOnClickListener {
            facebookWebView.loadUrl("https://www.facebook.com/uccjamaica/")
        }

        // Set on click listener for Twitter icon
        val twitterIcon = findViewById<ImageView>(R.id.twitter_icon)
        twitterIcon.setOnClickListener {
            twitterWebView.loadUrl("https://twitter.com/UCCjamaica")
        }

        // Set on click listener for Instagram icon
        val instagramIcon = findViewById<ImageView>(R.id.instagram_icon)
        instagramIcon.setOnClickListener {
            instagramWebView.loadUrl("https://www.instagram.com/uccjamaica/?hl=en")
        }
    }
}
