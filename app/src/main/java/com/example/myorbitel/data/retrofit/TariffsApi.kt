package com.example.myorbitel.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface TariffsApi {
    @GET("tariffs/{id}")
    suspend fun getTariffById(@Path("id") id: Int): List<Tariffs>
}