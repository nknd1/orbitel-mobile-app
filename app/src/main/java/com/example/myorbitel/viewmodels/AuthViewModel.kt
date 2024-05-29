package com.example.myorbitel.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myorbitel.models.AuthRequest
import com.example.myorbitel.models.ClientInfo
import com.example.myorbitel.models.ContractInfo
import com.example.myorbitel.utils.RetrofitInstance
import com.example.myorbitel.utils.RetrofitInstance.getToken
import com.example.myorbitel.utils.RetrofitInstance.saveToken
import kotlinx.coroutines.launch
import timber.log.Timber

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val _token = MutableLiveData<String>()
    val token: LiveData<String> get() = _token
    private val TAG = "AuthViewModel:"

    private val _clientInfo = MutableLiveData<ClientInfo>()

    val clientInfo: LiveData<ClientInfo> get() = _clientInfo


    private val _contracts = MutableLiveData<List<ContractInfo>>()
    val contracts: LiveData<List<ContractInfo>> get() = _contracts
    private val context = application.applicationContext

    fun login(authRequest: AuthRequest) = viewModelScope.launch {
        try {
            val response = RetrofitInstance.apiService.login(authRequest)
            if (response.isSuccessful) {
                response.body()?.let {
                    saveToken(context, it.token)
                    _token.value = it.token
                }
            } else {
                Log.d(TAG, "Login failed: ${response.errorBody()?.string()}")
            }
        } catch (e: Exception) {
            Log.d(TAG, "Exception during login: ${e.message}")
        }
    }

    fun getClientInfo() = viewModelScope.launch {
        val token = getToken(context)
        token?.let {
            try {
                val response = RetrofitInstance.apiService.getClientInfo("Bearer $it")
                if (response.isSuccessful) {
                    response.body()?.let {
                        _clientInfo.value = it
                    }
                } else {
                    Log.e(TAG, "Fetching client info failed: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.d(TAG, "Exception during fetching client info: ${e.message}")
            }
        } ?: run {
            Log.d(TAG, "Token is null")
        }
    }
    fun getContracts() = viewModelScope.launch {
        val token = getToken(context)
        token?.let {
            try {
                val response = RetrofitInstance.apiService.getContracts("Bearer $it")
                if (response.isSuccessful) {
                    response.body()?.let { it ->
                        _contracts.value = it
                    }
                } else {
                    Log.e(TAG, "Fetching contracts failed: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.d(TAG, "Exception during fetching contracts: ${e.message}")
            }
        } ?: run {
            Log.d(TAG, "Token is null")
        }
    }
}
