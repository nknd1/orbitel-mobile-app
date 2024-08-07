package com.example.myorbitel.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myorbitel.models.ContractInfoResponse
import com.example.myorbitel.utils.RetrofitInstance
import com.example.myorbitel.utils.getToken
import kotlinx.coroutines.launch

class ContractDetailsViewModel(
    application: Application,
) : AndroidViewModel(application) {
    private val _contractDetails = MutableLiveData<ContractInfoResponse>()
    val contractDetails: LiveData<ContractInfoResponse> get() = _contractDetails
    private val _serviceRemoved = MutableLiveData<Boolean>()
    val serviceRemoved: LiveData<Boolean> get() = _serviceRemoved
    private val TAG: String = ""

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
}
