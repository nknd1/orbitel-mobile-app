package com.example.myorbitel.repository

import com.example.myorbitel.service.main.MainApiService
import com.example.myorbitel.utils.apiRequestFlow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val mainApiService: MainApiService,
) {
    fun getUserInfo() = apiRequestFlow {
        mainApiService.getContractInfo()
    }
}