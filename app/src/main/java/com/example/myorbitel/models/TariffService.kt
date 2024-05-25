package com.example.myorbitel.models

data class Tariff(
    val tariff_id: Int,
    val tariff_name: String,
    val price_per_month: String,
    val speed: String
)

data class Service(
    val service_id: Int,
    val feature: String,
    val service_name: String,
    val price: String
)

data class TariffDetailsResponse(
    val tariff: Tariff,
    val services: List<Service>
)