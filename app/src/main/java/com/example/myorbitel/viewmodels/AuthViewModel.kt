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

class AuthViewModel(
    application: Application,
) : AndroidViewModel(application) {
    private val _token = MutableLiveData<String>()
    val token: LiveData<String> get() = _token
    private val TAG = "AuthViewModel:"
    private val _clientInfo = MutableLiveData<ClientInfo>()
    val clientInfo: LiveData<ClientInfo> get() = _clientInfo
    private val _contracts = MutableLiveData<List<ContractInfo>>()
    val contracts: LiveData<List<ContractInfo>> get() = _contracts

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
                        Log.e(TAG, "Неверные данные: ${response.errorBody()?.string()}")
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Ошибка сервера: ${e.message}")
            }
        }

    fun getClientInfo() =
        viewModelScope.launch {
            val token = getToken(getApplication())
            token?.let {
                try {
                    val response = RetrofitInstance.apiService.getClientInfo("Bearer $it")
                    when {
                        response.isSuccessful -> {
                            response.body()?.let { clientInfo ->
                                _clientInfo.value = clientInfo
                            }
                        }
                        else -> {
                            Log.e(TAG, "Ошибка получение информации о клиенте: ${response.errorBody()?.string()}")
                        }
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Ошибка сервера: ${e.message}")
                }
            } ?: run {
                Log.e(TAG, "Token is null")
            }
        }

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
                        Log.e(TAG, "Ошибка получения информации о договорах клиента: ${response.errorBody()?.string()}")
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Ошибка сервера: ${e.message}")
                }
            } ?: run {
                Log.e(TAG, "Token is null")
            }
        }
}
