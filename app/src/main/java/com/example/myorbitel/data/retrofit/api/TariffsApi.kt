package com.example.myorbitel.data.retrofit.api

import com.example.myorbitel.models.Services
import com.example.myorbitel.models.TariffDetailsResponse
import com.example.myorbitel.models.Tariffs
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TariffsApi {
    @GET("tariffs/{id}")
    suspend fun getTariffById(
        @Path("id") id: Int,
    ): List<Tariffs>

    @GET("tariffs")
    suspend fun getAllTariffs(): List<Tariffs>

    @GET("services")
    suspend fun getAllServices(): List<Services>

/*
    @POST("contracts/service")
    suspend fun addServiceToTariff(@Body request: AddServiceRequest): Response<AddServiceResponse>

\
 */

    @GET("tariffs/{id}")
    fun getTariffDetails(
        @Path("id") id: Int,
    ): Call<TariffDetailsResponse>
    /*
    @POST("topUp")
    suspend fun topUpBalance(@Query q)

     */
}
