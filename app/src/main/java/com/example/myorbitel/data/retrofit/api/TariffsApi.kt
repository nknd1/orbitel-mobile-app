package com.example.myorbitel.data.retrofit.api

import com.example.myorbitel.data.retrofit.model.Tariffs
import retrofit2.http.GET
import retrofit2.http.Path

interface TariffsApi {
    @GET("tariffs/{id}")
    suspend fun getTariffById(@Path("id") id: Int): List<Tariffs>
}