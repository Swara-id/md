package com.example.swaraapp.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swaraapp.api.SignUpRequest
import com.example.swaraapp.api.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class SignUpViewModel : ViewModel() {

    private val _signUpResult = MutableLiveData<Boolean>()
    val signUpResult: LiveData<Boolean> get() = _signUpResult

    private val _signUpError = MutableLiveData<String>()
    val signUpError: LiveData<String> get() = _signUpError

    fun signUp(name: String, email: String, password: String) {
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            _signUpError.value = "All fields must be filled"
            return
        }

        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.signUp(SignUpRequest(name, email, password))
                }
                if (response.isSuccessful && response.body() != null) {
                    _signUpResult.value = true
                } else {
                    _signUpError.value = "Sign up failed: ${response.message()}"
                }
            } catch (e: HttpException) {
                _signUpError.value = "Sign up failed: ${e.message()}"
            } catch (e: Exception) {
                _signUpError.value = "An unexpected error occurred: ${e.message}"
            }
        }
    }
}
