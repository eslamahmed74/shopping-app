package com.example.shoppingapp.presentation.loginScreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor() : ViewModel() {

    private val _loginState = MutableStateFlow(LoginUiState())
    val loginState = _loginState.asStateFlow()

    fun onChangeEmail(newValue: String) = _loginState.update { it.copy(email = newValue) }

    fun onChangePassword(newValue: String) = _loginState.update { it.copy(password = newValue) }
}