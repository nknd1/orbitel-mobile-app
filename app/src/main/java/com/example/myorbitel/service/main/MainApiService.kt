package com.example.myorbitel.service.main

import com.example.myorbitel.models.ContractInfoResponse
import retrofit2.Response
import retrofit2.http.GET

interface MainApiService {
    @GET("contract/info")
    suspend fun getContractInfo(): Response<ContractInfoResponse>
}