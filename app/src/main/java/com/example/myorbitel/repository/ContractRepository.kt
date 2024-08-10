package com.example.myorbitel.repository

import android.util.Log
import com.example.myorbitel.data.models.response.ContractInfoResponse
import com.example.myorbitel.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ContractRepository
    @Inject
    constructor(
        private val apiService: ApiService,
    ) {
        private val TAG = ContractRepository::class.java.simpleName

        suspend fun getContractDetails(
            token: String,
            contractId: Int,
        ): ContractInfoResponse? =
            withContext(Dispatchers.IO) {
                try {
                    val response = apiService.getContractDetails("Bearer $token", contractId)
                    if (response.isSuccessful) {
                        response.body()
                    } else {
                        Log.e(TAG, "Fetching contract details failed: ${response.errorBody()?.string()}")
                        null
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Exception during fetching contract details: ${e.message}")
                    null
                }
            }

        suspend fun removeServiceFromContract(
            token: String,
            contractId: Int,
            serviceId: Int,
        ): Boolean =
            withContext(Dispatchers.IO) {
                try {
                    val response = apiService.removeServiceFromContract("Bearer $token", contractId, serviceId)
                    if (response.isSuccessful) {
                        true
                    } else {
                        Log.e(TAG, "Removing service failed: ${response.errorBody()?.string()}")
                        false
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Exception during removing service: ${e.message}")
                    false
                }
            }
    }
