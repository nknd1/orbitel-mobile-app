package com.example.myorbitel.presentation.fragments.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _navigateToHomeFrag = MutableLiveData<Boolean>()
    val navigateToHomeFrag: LiveData<Boolean>
        get() = _navigateToHomeFrag

    fun navigateToHomeFrag(){
        _navigateToHomeFrag.value = true
    }

    fun onNavigateToHomeFrag(){
        _navigateToHomeFrag.value = false
    }
}