package com.example.myorbitel.utils

import com.example.myorbitel.data.retrofit.api.TariffsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    val api : TariffsApi by lazy {
        Retrofit.Builder()
            .baseUrl(Utils.BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TariffsApi::class.java)
    }
}