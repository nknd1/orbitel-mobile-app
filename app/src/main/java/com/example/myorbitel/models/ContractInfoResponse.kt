package com.example.myorbitel.models

import com.google.gson.annotations.SerializedName

data class ContractInfoResponse(
    @SerializedName("data")
    val contractInfo: ContractInfo,
    val message: String
)
