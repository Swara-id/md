package com.example.swaraapp.ui.home

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.swaraapp.R
import com.example.swaraapp.api.User
import com.example.swaraapp.challenge.ChallengeActivity
import com.example.swaraapp.ui.bisara.BisaraActivity
import com.example.swaraapp.ui.lisara.LisaraActivity
import com.example.swaraapp.ui.pusara.PusaraActivity
import com.example.swaraapp.ui.terjemahkan.TerjemahkanActivity

class HomeActivity : AppCompatActivity() {


    private lateinit var profileImage: ImageView
    private lateinit var welcomeText: TextView
    private lateinit var inviteText: TextView
    private lateinit var pointsText: TextView
    private lateinit var recentActivitiesText: TextView
    private lateinit var recentActivitiesLayout: LinearLayout
    private lateinit var continueLearningText: TextView
    private lateinit var bottomNavigation: LinearLayout
    private lateinit var home: TextView
    private lateinit var translate: TextView
    private lateinit var sign: TextView
    private lateinit var profile: TextView
    private lateinit var buttonTogether: ImageButton
    private lateinit var buttonPractice: ImageButton
    private lateinit var buttonGather: ImageButton
    private lateinit var buttonChallenge: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        // Initialize views
        profileImage = findViewById(R.id.profile_image)
        welcomeText = findViewById(R.id.welcome_text)
        inviteText = findViewById(R.id.invite_text)
        pointsText = findViewById(R.id.points_text)
        recentActivitiesText = findViewById(R.id.recent_activities_text)
        recentActivitiesLayout = findViewById(R.id.recent_activities_layout)
        continueLearningText = findViewById(R.id.continue_learning_text)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        home = findViewById(R.id.home)
        translate = findViewById(R.id.translate)
        sign = findViewById(R.id.sign)
        profile = findViewById(R.id.profile)
        buttonTogether = findViewById(R.id.button_together)
        buttonPractice = findViewById(R.id.button_practice)
        buttonGather = findViewById(R.id.button_gather)
        buttonChallenge = findViewById(R.id.button_challenge)

        // Set event listeners for bottom navigation
        home.setOnClickListener {
            // Handle home click
        }
        translate.setOnClickListener {
            val intent = Intent(this, TerjemahkanActivity::class.java)
            startActivity(intent)
        }
        sign.setOnClickListener {
            // Handle sign click
        }

        profile.setOnClickListener {
            // Handle profile click
        }

        buttonTogether.setOnClickListener {
            val intent = Intent(this, BisaraActivity::class.java)
            startActivity(intent)
        }
        buttonPractice.setOnClickListener{
            val intent = Intent(this, LisaraActivity::class.java)
            startActivity(intent)
        }
        buttonGather.setOnClickListener{
            val intent = Intent(this, PusaraActivity::class.java)
            startActivity(intent)
        }
        buttonChallenge.setOnClickListener{
            val intent = Intent(this, ChallengeActivity::class.java)
            startActivity(intent)
        }
    }
}
