package com.example.swaraapp.ui.signup

import android.content.Intent
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
import com.example.swaraapp.ui.home.HomeActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var fullNameEditText: EditText
    private lateinit var userNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var agreeCheckBox: CheckBox
    private lateinit var signUpButton: Button
    private lateinit var logInTextView: TextView

    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        fullNameEditText = findViewById(R.id.full_name)
        userNameEditText = findViewById(R.id.user_name)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        agreeCheckBox = findViewById(R.id.remember_me)
        signUpButton = findViewById(R.id.btnLogin)
        logInTextView = findViewById(R.id.sign_up)

        signUpButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString().trim()
            val userName = userNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (agreeCheckBox.isChecked) {
                signUpViewModel.signUp(fullName, userName, email, password)
            } else {
                Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            }
        }

        signUpViewModel.signUpResult.observe(this, Observer { result ->
            if (result) {
                Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                navigateToHome()
            } else {
                Toast.makeText(this, "Sign Up Failed", Toast.LENGTH_SHORT).show()
            }
        })

        signUpViewModel.signUpError.observe(this, Observer { error ->
            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            }
        })

        logInTextView.setOnClickListener {
            // Handle navigation to login screen
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
