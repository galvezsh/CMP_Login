package com.galvezsh.cmplogin.presentation.login_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _rememberMe = MutableStateFlow( false )
    val rememberMe: StateFlow<Boolean> = _rememberMe.asStateFlow()

    private val _isLoading = MutableStateFlow( false )
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun onUsernameChanged(newUsername: String) {
        _username.value = newUsername
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    fun onRememberMeChanged(checked: Boolean) {
        _rememberMe.value = checked
    }

    fun onLogin() {
        viewModelScope.launch( context = Dispatchers.IO ) {
            _isLoading.value = true
            delay(3000)

            // TODO: Implement login logic

            _isLoading.value = false
        }
    }
}