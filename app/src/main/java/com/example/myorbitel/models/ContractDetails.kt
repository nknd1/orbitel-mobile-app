package com.example.myorbitel.models

import com.google.gson.annotations.SerializedName

data class ContractDetails(
    @SerializedName("contract_id")
    val contract_id: Int,
    @SerializedName("balance")
    val balance: String,
    @SerializedName("speed")
    val speed: String,
    @SerializedName("tariff_name")
    val tariff_name: String,
    @SerializedName("tariff_price")
    val tariff_price: String,
)
