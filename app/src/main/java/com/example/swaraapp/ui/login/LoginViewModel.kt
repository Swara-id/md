package com.example.swaraapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult

    fun login(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            // Here you would implement the actual login logic, e.g., making a network request
            // For the sake of this example, let's assume the login is always successful
            _loginResult.value = true
        } else {
            _loginResult.value = false
        }
    }
}
