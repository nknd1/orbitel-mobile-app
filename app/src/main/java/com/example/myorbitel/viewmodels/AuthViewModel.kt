package com.example.myorbitel.viewmodels

import android.annotation.SuppressLint
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

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val _token = MutableLiveData<String>()
    val token: LiveData<String> get() = _token

    @Suppress("ktlint:standard:property-naming")
    private val TAG = "AuthViewModel:"
    private val _clientInfo = MutableLiveData<ClientInfo>()
    val clientInfo: LiveData<ClientInfo> get() = _clientInfo
    private val _contracts = MutableLiveData<List<ContractInfo>>()
    val contracts: LiveData<List<ContractInfo>> get() = _contracts
    // private val context = application.applicationContext

    @SuppressLint("LogNotTimber")
    fun login(authRequest: AuthRequest) =
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.apiService.login(authRequest)
                when {
                    response.isSuccessful -> {
                        response.body()?.let {
                            saveToken(getApplication(), it.token)
                            _token.value = it.token
                        }
                    }
                    else -> {
                        Log.e(TAG, "Login failed: ${response.errorBody()?.string()}")
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Exception during login: ${e.message}")
            }
        }

    @SuppressLint("LogNotTimber")
    fun getClientInfo() =
        viewModelScope.launch {
            val token = getToken(getApplication())
            token?.let {
                try {
                    val response = RetrofitInstance.apiService.getClientInfo("Bearer $it")
                    when {
                        response.isSuccessful -> {
                            response.body()?.let { clientInfo ->
                                _clientInfo.value = clientInfo // remove "it"
                            }
                        }
                        else -> {
                            Log.e(TAG, "Fetching client info failed: ${response.errorBody()?.string()}")
                        }
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Exception during fetching client info: ${e.message}")
                }
            } ?: run {
                Log.e(TAG, "Token is null")
            }
        }

    @SuppressLint("LogNotTimber")
    fun getContracts() =
        viewModelScope.launch {
            val token = getToken(getApplication())
            token?.let {
                try {
                    val response = RetrofitInstance.apiService.getContracts("Bearer $it")
                    if (response.isSuccessful) {
                        response.body()?.let { contracts ->
                            _contracts.value = contracts
                        }
                    } else {
                        Log.e(TAG, "Fetching contracts failed: ${response.errorBody()?.string()}")
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Exception during fetching contracts: ${e.message}")
                }
            } ?: run {
                Log.e(TAG, "Token is null")
            }
        }

    fun getContractDetails(contractId: Int) {
        // Здесь вызовите API для получения деталей договора
        // и обновите _contractDetails
    }
}
