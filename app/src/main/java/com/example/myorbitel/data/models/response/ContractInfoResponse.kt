package com.example.myorbitel.data.models.response

import com.example.myorbitel.data.models.ContractDetails
import com.example.myorbitel.data.models.Service

data class ContractInfoResponse(
    val contractDetails: ContractDetails,
    val services: List<Service>,
)
