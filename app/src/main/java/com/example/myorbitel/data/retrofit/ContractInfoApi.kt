package com.example.myorbitel.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface ContractInfoApi {
    @GET("contracts/{id}")
    suspend fun getContractInfo(@Path("id") id: Int): List<ContractInformation>

}