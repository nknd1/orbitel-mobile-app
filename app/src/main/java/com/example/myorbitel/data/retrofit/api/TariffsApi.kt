package com.example.myorbitel.data.retrofit.api

import com.example.myorbitel.models.Tariffs
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TariffsApi {
    @GET("tariffs/{id}")
    suspend fun getTariffById(@Path("id") id: Int): List<Tariffs>

    @GET("tariffs")
    suspend fun getAllTariffs(): List<Tariffs>
}