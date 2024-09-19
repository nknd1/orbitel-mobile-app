package com.example.myorbitel.data.models

import com.google.gson.annotations.SerializedName

data class Tariffs(
    @SerializedName("tariff_id")
    val tariff_id: Int,
    @SerializedName("tariff_name")
    val tariff_name: String,
    @SerializedName("price_per_month")
    val price_per_month: String,
    @SerializedName("speed")
    val speed: String,
)
