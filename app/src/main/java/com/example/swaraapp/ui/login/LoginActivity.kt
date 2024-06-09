package com.example.swaraapp.ui.login

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.swaraapp.R

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var rememberMeCheckBox: CheckBox
    private lateinit var forgotPasswordTextView: TextView
    private lateinit var loginButton: Button
    private lateinit var signUpTextView: TextView

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        rememberMeCheckBox = findViewById(R.id.remember_me)
        forgotPasswordTextView = findViewById(R.id.forgot_password)
        loginButton = findViewById(R.id.btnLogin)
        signUpTextView = findViewById(R.id.sign_up)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            loginViewModel.login(email, password)
        }

        loginViewModel.loginResult.observe(this, Observer { result ->
            if (result) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                // Navigate to the next screen
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        })

        signUpTextView.setOnClickListener {
            // Handle sign-up navigation
        }

        forgotPasswordTextView.setOnClickListener {
            // Handle forgot password
        }
    }
}

