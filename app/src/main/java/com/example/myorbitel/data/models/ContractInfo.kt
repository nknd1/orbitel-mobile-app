package com.example.myorbitel.data.models

import com.google.gson.annotations.SerializedName

data class ContractInfo(
    @SerializedName("contract_id")
    val contract_id: Int,
    @SerializedName("connect_address")
    val connect_address: String,
    @SerializedName("balance")
    val balance: String,
    @SerializedName("contract_number")
    val contract_number: String,
    @SerializedName("personal_account")
    val personal_account: String,
)
