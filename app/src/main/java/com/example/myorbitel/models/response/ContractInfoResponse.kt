package com.example.myorbitel.models.response

import com.example.myorbitel.models.ContractDetails
import com.example.myorbitel.models.Service

data class ContractInfoResponse(
    val contractDetails: ContractDetails,
    val services: List<Service>,
)
