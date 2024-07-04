package com.example.myorbitel.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myorbitel.models.Service
import com.example.myorbitel.utils.RetrofitInstance
import com.example.myorbitel.utils.RetrofitInstance.getToken
import kotlinx.coroutines.launch

class ServiceListViewModel(
    application: Application,
) : AndroidViewModel(application) {
    private val _services = MutableLiveData<List<Service>>()
    val services: LiveData<List<Service>> get() = _services

    private val _serviceAdded = MutableLiveData<Boolean>()
    val serviceAdded: LiveData<Boolean> get() = _serviceAdded

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun getAllServices() =
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.apiService.getAllServices()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _services.value = it
                    }
                } else {
                    Log.e("ServiceListViewModel", "Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("ServiceListViewModel", "Exception: ${e.message}")
            }
        }

    fun addServiceToContract(
        contractId: Int,
        serviceId: Int,
    ) {
        viewModelScope.launch {
            val token = getToken(getApplication())
            token?.let {
                try {
                    val response =
                        RetrofitInstance.apiService.addServiceToContract(
                            "Bearer $it",
                            contractId,
                            serviceId,
                        )
                    if (response.isSuccessful) {
                        _serviceAdded.value = true
                    } else {
                        Log.e(
                            "ServiceListViewModel",
                            "Adding service failed: ${response.errorBody()?.string()}",
                        )
                        _serviceAdded.value = false
                    }
                } catch (e: Exception) {
                    Log.e("ServiceListViewModel", "Exception during adding service: ${e.message}")
                    _serviceAdded.value = false
                }
            } ?: run {
                Log.e("ServiceListViewModel", "Token is null")
                _serviceAdded.value = false
            }
        }
    }
}
