package com.example.myorbitel.models

data class Services(
    val feature: String,
    val price: String,
    val service_id: String,
    val service_name: String
)


data class AddServiceRequest(val service_id: String, val tariff_id: Int)

data class AddServiceResponse(
    val message: String
)