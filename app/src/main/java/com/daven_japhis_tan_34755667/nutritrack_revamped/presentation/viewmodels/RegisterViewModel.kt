package com.daven_japhis_tan_34755667.nutritrack_revamped.presentation.viewmodels;

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegisterViewModel: ViewModel() {
    var userId by mutableStateOf("")
    private set

    var phoneNumber by mutableStateOf("")
    private set

    var phoneNumberVisibility by mutableStateOf(false)
    private set

    var password by mutableStateOf("")
    private set

    var passwordVisible by mutableStateOf(false)
    private set

    var confirmPassword by mutableStateOf("")
    private set

    var confirmPasswordVisible by mutableStateOf(false)
    private set

    fun updateUserId(id: String) {
        userId = id
    }

    fun updatePassword(pass: String) {
        password = pass
    }

    fun updatePhoneNumber(phone: String) {
        phoneNumber = phone
    }

    fun updateConfirmPassword(confirmPass: String) {
        confirmPassword = confirmPass
    }

    fun togglePhoneNumberVisibility() {
        phoneNumberVisibility = !phoneNumberVisibility
    }

    fun toggleVisibility() {
        passwordVisible = !passwordVisible
    }

    fun toggleConfirmVisibility() {
        confirmPasswordVisible = !confirmPasswordVisible
    }
}
