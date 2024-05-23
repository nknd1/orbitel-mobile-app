package com.example.myorbitel.models

import com.google.gson.annotations.SerializedName

data class TopUpRequest(
    @SerializedName("contract_id")
    val contract_id: Int,
    @SerializedName("balance")
    val balance: Int?
)
