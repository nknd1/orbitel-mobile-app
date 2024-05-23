package com.example.myorbitel.data.retrofit.api

import com.example.myorbitel.models.ContractInformation
import com.example.myorbitel.models.Deposit
import com.example.myorbitel.models.TopUpRequest
import com.example.myorbitel.models.TopUpResponse
import com.example.myorbitel.models.Writeoff
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
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


    @GET("contracts/writeoff")
    suspend fun getWriteOffs(): List<Writeoff>

    @GET("contracts/deposit")
    suspend fun getDeposits(): List<Deposit>

    @POST("contracts/top-up")
    fun topUpBalance(@Body request: TopUpRequest): Call<TopUpResponse>
}