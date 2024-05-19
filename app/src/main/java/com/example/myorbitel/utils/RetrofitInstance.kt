package com.example.myorbitel.utils

import com.example.myorbitel.data.retrofit.api.ContractInfoApi
import com.example.myorbitel.data.retrofit.api.TariffsApi
import com.example.myorbitel.utils.Utils.BASE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val api: TariffsApi by lazy {
        retrofit.create(TariffsApi::class.java)
    }
    val api_v1: ContractInfoApi by lazy {
        retrofit.create(ContractInfoApi::class.java)
    }
}
