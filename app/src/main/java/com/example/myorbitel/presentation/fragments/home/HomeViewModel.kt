package com.example.myorbitel.presentation.fragments.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myorbitel.data.retrofit.api.ContractInfoApi
import com.example.myorbitel.models.ContractInformation
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel(private val _contractInformation: MutableLiveData<ContractInformation>) : ViewModel() {
    private val contractInfoApi: ContractInfoApi = createApiService()
    val contractInformation: MutableLiveData<ContractInformation> get() = _contractInformation





    private fun createApiService(): ContractInfoApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3001/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ContractInfoApi::class.java)
    }
}