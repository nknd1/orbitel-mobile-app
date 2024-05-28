package com.example.myorbitel.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myorbitel.models.AuthRequest
import com.example.myorbitel.network.LoginResult
import com.example.myorbitel.utils.RetrofitInstance

/*
class LoginViewModel : ViewModel() {
    private val apiService = RetrofitInstance.apiService

    fun login(authRequest: AuthRequest) = liveData {
        try {
            val response = apiService.login(authRequest)
            if (response.isSuccessful) {
                emit(LoginResult.Success(response.body()?.token ?: ""))
            } else {
                emit(LoginResult.Error("Login failed"))
            }
        } catch (e: Exception) {
            emit(LoginResult.Error(e.message ?: "Unknown error"))
        }
    }
}




 */