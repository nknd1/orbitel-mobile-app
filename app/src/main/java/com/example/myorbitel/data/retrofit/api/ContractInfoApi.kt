package com.example.myorbitel.data.retrofit.api

import com.example.myorbitel.models.ContractInformation
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ContractInfoApi {
    @GET("contracts/{id}")
    suspend fun getContractInfo(@Path("id") id: Int): List<ContractInformation>


   // @POST("contracts/balance/{id}")
   // suspend fun topUpBalance(@Query )
    @POST("contracts/auth")
    suspend fun loginToContracts()
}