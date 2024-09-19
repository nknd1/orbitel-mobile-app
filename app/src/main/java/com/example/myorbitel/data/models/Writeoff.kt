package com.example.myorbitel.data.models

import com.google.gson.annotations.SerializedName

data class Writeoff(
    @SerializedName("writeoff_id")
    val writeoff_id: Int,
    @SerializedName("date_writeoffs")
    val date_writeoffs: String,
    @SerializedName("time_writeoffs")
    val time_writeoffs: String,
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("reason")
    val reason: String,
    @SerializedName("contract_id")
    val contractId: Int,
)
