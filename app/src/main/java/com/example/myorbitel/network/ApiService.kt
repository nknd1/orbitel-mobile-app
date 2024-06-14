package com.example.myorbitel.network

import com.example.myorbitel.models.AuthRequest
import com.example.myorbitel.models.ClientInfo
import com.example.myorbitel.models.ContractDetails
import com.example.myorbitel.models.ContractInfo
import com.example.myorbitel.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("clients/login")
    suspend fun login(
        @Body authRequest: AuthRequest,
    ): Response<LoginResponse>

    @GET("clients/info")
    suspend fun getClientInfo(
        @Header("Authorization") token: String,
    ): Response<ClientInfo>

    @GET("clients/contract")
    suspend fun getContracts(
        @Header("Authorization") token: String,
    ): Response<List<ContractInfo>>

    @GET("clients/contract-details")
    suspend fun getContractDetails(
        @Header("Authorization") token: String,
        @Query("contract_id") contractId: String,
    ): Response<ContractDetails>
}
