package com.example.swaraApp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.swaraapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val signUp = findViewById<TextView>(R.id.sign_up)
        val rememberMe = findViewById<CheckBox>(R.id.remember_me)
        val forgotPassword = findViewById<TextView>(R.id.forgot_password)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)

        btnLogin.setOnClickListener {
            // Handle login button click
        }

        signUp.setOnClickListener {
            // Handle sign up text click
        }

        forgotPassword.setOnClickListener {
            // Handle forgot password text click
        }
    }
}
