package com.example.myorbitel.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myorbitel.models.Tariffs
import com.example.myorbitel.utils.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TariffViewModel : ViewModel() {
    private val _tariffs = MutableLiveData<List<Tariffs>>()
    val tariffs: LiveData<List<Tariffs>> get() = _tariffs

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun getTariffs() {
        _loading.value = true
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.apiService.getAllTariffs()
                withContext(Dispatchers.Main) {
                    _tariffs.value = response
                    _loading.value = false
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    _error.value = "Error: ${e.message}"
                    _loading.value = false
                }
            }
        }
    }
}
