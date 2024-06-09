package com.example.swaraapp.ui.signup

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

class SignUpActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var agreeCheckBox: CheckBox
    private lateinit var signUpButton: Button
    private lateinit var logInTextView: TextView

    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        nameEditText = findViewById(R.id.name)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        agreeCheckBox = findViewById(R.id.remember_me)
        signUpButton = findViewById(R.id.btnLogin)
        logInTextView = findViewById(R.id.sign_up)

        signUpButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (agreeCheckBox.isChecked) {
                signUpViewModel.signUp(name, email, password)
            } else {
                Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            }
        }

        signUpViewModel.signUpResult.observe(this, Observer { result ->
            if (result) {
                Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                // Navigate to the next screen
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
}
