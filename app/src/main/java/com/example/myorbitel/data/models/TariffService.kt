package com.example.myorbitel.data.models

import com.google.gson.annotations.SerializedName

data class Tariff(
    @SerializedName("tariff_id")
    val tariff_id: Int,
    @SerializedName("tariff_name")
    val tariff_name: String,
    @SerializedName("price_per_month")
    val price_per_month: String,
    @SerializedName("speed")
    val speed: String,
)

data class Service(
    @SerializedName("service_id")
    val service_id: Int,
    @SerializedName("feature")
    val feature: String,
    @SerializedName("service_name")
    val service_name: String,
    @SerializedName("price")
    val price: String,
)

data class TariffDetailsResponse(
    @SerializedName("tariff")
    val tariff: Tariff,
    @SerializedName("services")
    val services: List<Service>,
)
