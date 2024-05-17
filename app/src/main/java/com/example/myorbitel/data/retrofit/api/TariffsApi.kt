package com.example.myorbitel.data.retrofit.api

import com.example.myorbitel.models.Tariffs
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TariffsApi {
    @GET("tariffs/{id}")
    suspend fun getTariffById(@Path("id") id: Int): List<Tariffs>

    @GET("tariffs")
    suspend fun getAllTariffs(): List<Tariffs>


    /*
    @POST("topUp")
    suspend fun topUpBalance(@Query q)

     */
}