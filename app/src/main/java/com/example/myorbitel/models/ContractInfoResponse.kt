package com.example.myorbitel.models

data class ContractInfoResponse(
    val contractDetails: ContractDetails,
    val services: List<Service>,
)
