package com.daven_japhis_tan_34755667.nutritrack_revamped.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    var userId by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    var passwordVisible by mutableStateOf(false)
        private set

    fun updateUserId(id: String) {
        userId = id
    }

    fun updatePassword(pass: String) {
        password = pass
    }

    fun toggleVisibility() {
        passwordVisible = !passwordVisible
    }

    fun authorize() {
        viewModelScope.launch {

        isLoading = true
        // Simulate a network call or authentication process
        // In a real application, you would replace this with actual logic
        // to authenticate the user with a backend service.
        Thread.sleep(2000) // Simulating network delay
        isLoading = false

        // Here you would typically check the credentials and update the UI accordingly.
        // For example, if authentication fails, you might show an error message.
        }
    }


}