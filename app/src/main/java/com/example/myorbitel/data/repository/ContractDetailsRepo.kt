package com.example.myorbitel.data.repository

import com.example.myorbitel.data.network.ApiService
import javax.inject.Inject

class ContractDetailsRepo
    @Inject
    constructor(
        private val apiService: ApiService,
    ) {
        fun getContractDetails()  {
        }
    }
