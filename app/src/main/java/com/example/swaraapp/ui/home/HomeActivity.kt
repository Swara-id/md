package com.example.swaraapp.ui.home

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.swaraapp.R

class HomeActivity : AppCompatActivity() {

    private lateinit var profileImage: ImageView
    private lateinit var welcomeText: TextView
    private lateinit var inviteText: TextView
    private lateinit var pointsText: TextView
    private lateinit var signLanguageOptions: LinearLayout
    private lateinit var recentActivitiesText: TextView
    private lateinit var recentActivitiesLayout: LinearLayout
    private lateinit var continueLearningText: TextView
    private lateinit var bottomNavigation: LinearLayout
    private lateinit var home: TextView
    private lateinit var translate: TextView
    private lateinit var sign: TextView
    private lateinit var profile: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize views
        profileImage = findViewById(R.id.profile_image)
        welcomeText = findViewById(R.id.welcome_text)
        inviteText = findViewById(R.id.invite_text)
        pointsText = findViewById(R.id.points_text)
        signLanguageOptions = findViewById(R.id.sign_language_options)
        recentActivitiesText = findViewById(R.id.recent_activities_text)
        recentActivitiesLayout = findViewById(R.id.recent_activities_layout)
        continueLearningText = findViewById(R.id.continue_learning_text)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        home = findViewById(R.id.home)
        translate = findViewById(R.id.translate)
        sign = findViewById(R.id.sign)
        profile = findViewById(R.id.profile)

        // Set event listeners for bottom navigation
        home.setOnClickListener {
            // Handle home click
        }

        translate.setOnClickListener {
            // Handle translate click
        }

        sign.setOnClickListener {
            // Handle sign click
        }

        profile.setOnClickListener {
            // Handle profile click
        }
    }
}
