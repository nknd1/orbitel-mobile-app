package com.example.myorbitel.data.models

import com.google.gson.annotations.SerializedName

data class Deposit(
    @SerializedName("deposit_id")
    val deposit_id: Int,
    @SerializedName("date_deposits")
    val date_deposits: String,
    @SerializedName("time_deposits")
    val time_deposits: String,
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("contract_id")
    val contractId: Int,
)
