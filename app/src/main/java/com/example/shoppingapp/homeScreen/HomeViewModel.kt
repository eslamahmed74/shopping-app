package com.example.shoppingapp.homeScreen

import android.view.View
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {
    private val _searchState = MutableStateFlow("")
    val searchState = _searchState.asStateFlow()

    fun setSearchFiledState(newValue: String) {
        _searchState.value = newValue
    }
}