package com.example.myorbitel.viewmodels

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myorbitel.models.ContractInfoResponse
import com.example.myorbitel.models.TopUpRequest
import com.example.myorbitel.utils.RetrofitInstance
import com.example.myorbitel.utils.RetrofitInstance.getToken
import kotlinx.coroutines.launch

class ContractDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val _contractDetails = MutableLiveData<ContractInfoResponse>()
    val contractDetails: LiveData<ContractInfoResponse> get() = _contractDetails

    private val _serviceRemoved = MutableLiveData<Boolean>()
    val serviceRemoved: LiveData<Boolean> get() = _serviceRemoved

    @Suppress("ktlint:standard:property-naming")
    private val TAG: String = ""

    @SuppressLint("LogNotTimber")
    fun getContractDetails(contractId: Int) =
        viewModelScope.launch {
            val token = getToken(getApplication())
            token?.let {
                try {
                    val response =
                        RetrofitInstance.apiService.getContractDetails("Bearer $it", contractId)
                    if (response.isSuccessful) {
                        response.body()?.let { contractInfoResponse ->
                            _contractDetails.value = contractInfoResponse
                        }
                    } else {
                        Log.e(
                            TAG,
                            "Fetching contract details failed: ${response.errorBody()?.string()}",
                        )
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Exception during fetching contract details: ${e.message}")
                }
            } ?: run {
                Log.e(TAG, "Token is null")
            }
        }

    @SuppressLint("LogNotTimber")
    fun removeServiceFromContract(
        contractId: Int,
        serviceId: Int,
    ) {
        viewModelScope.launch {
            val token = getToken(getApplication())
            token?.let {
                try {
                    val response = RetrofitInstance.apiService.removeServiceFromContract("Bearer $it", contractId, serviceId)
                    if (response.isSuccessful) {
                        _serviceRemoved.value = true
                        getContractDetails(contractId)
                    } else {
                        Log.e(TAG, "Removing service failed: ${response.errorBody()?.string()}")
                        _serviceRemoved.value = false
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Exception during removing service: ${e.message}")
                    _serviceRemoved.value = false
                }
            } ?: run {
                Log.e(TAG, "Token is null")
                _serviceRemoved.value = false
            }
        }
    }

    @SuppressLint("LogNotTimber")
    fun topUpBalance(
        contractId: Int,
        amount: Double?,
    ) {
        viewModelScope.launch {
            val token = getToken(getApplication())
            token?.let {
                try {
                    val response = RetrofitInstance.apiService.topUpBalance("Bearer $it", contractId, TopUpRequest(amount))
                    if (response.isSuccessful) {
                        Toast.makeText(getApplication(), "Баланс пополнен успешно", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.e("ContractDetailsVM", "Error topping up balance: ${response.errorBody()?.string()}")
                        Toast.makeText(getApplication(), "Ошибка пополнения баланса", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Log.e("ContractDetailsVM", "Exception: ${e.message}")
                    Toast.makeText(getApplication(), "Ошибка пополнения баланса", Toast.LENGTH_SHORT).show()
                }
            } ?: run {
                Log.e("ContractDetailsVM", "Token is null")
            }
        }
    }
}
