package com.example.swaraapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swaraapp.api.LoginRequest
import com.example.swaraapp.api.RetrofitInstance
import com.example.swaraapp.api.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class LoginViewModel : ViewModel() {
    private val _userdata = MutableLiveData<User?>()

    val userData : MutableLiveData<User?> = _userdata

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult

    private val _loginError = MutableLiveData<String?>()
    val loginError: LiveData<String?> get() = _loginError

    fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _loginError.value = "All fields must be filled"
            return
        }

        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.login(LoginRequest(email, password)).execute()
                }
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null)
                    {
                        _loginResult.value = true
                        _userdata.value = response.body()?.user
                    } else {
                        _loginError.value = "Login failed: ${response.message()}"
                    }
                } else {
                    _loginError.value = "Login failed: ${response.message()}"
                }
            } catch (e: HttpException) {
                _loginError.value = "Login failed: ${e.message()}"
            } catch (e: Exception) {
                _loginError.value = "An unexpected error occurred: ${e.message}"
            }
        }
    }
}
