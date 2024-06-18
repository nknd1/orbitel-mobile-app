package com.example.myorbitel.network

import com.example.myorbitel.models.AuthRequest
import com.example.myorbitel.models.ClientInfo
import com.example.myorbitel.models.ContractInfo
import com.example.myorbitel.models.ContractInfoResponse
import com.example.myorbitel.models.LoginResponse
import com.example.myorbitel.models.Service
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
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
    ): Response<ContractInfoResponse>

    @DELETE("clients/contracts/{contract_id}/services/{service_id}")
    suspend fun removeServiceFromContract(
        @Header("Authorization") token: String,
        @Path("contract_id") contractId: String,
        @Path("service_id") serviceId: Int,
    ): Response<Unit>

    @GET("services")
    suspend fun getAllServices(): Response<List<Service>>

    @POST("clients/contracts/{contract_id}/services/{service_id}")
    suspend fun addServiceToContract(
        @Header("Authorization") token: String,
        @Path("contract_id") contractId: String,
        @Path("service_id") serviceId: Int,
    ): Response<Any>
}
