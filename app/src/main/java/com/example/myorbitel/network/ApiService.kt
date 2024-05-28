package com.example.myorbitel.network


import androidx.lifecycle.LiveData
import com.example.myorbitel.models.AuthRequest
import com.example.myorbitel.models.ClientInfo
import com.example.myorbitel.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("clients/login")
    suspend fun login(@Body authRequest: AuthRequest): Response<LoginResponse>


    @GET("clients/info")
    suspend fun getClientInfo(@Header("Authorization") token: String): Response<ClientInfo>
}
