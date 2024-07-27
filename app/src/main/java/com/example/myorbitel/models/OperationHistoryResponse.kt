package com.example.myorbitel.models

import com.google.gson.annotations.SerializedName

data class OperationHistoryResponse(
    @SerializedName("deposits")
    val deposits: List<Deposit>,
    @SerializedName("writeoffs")
    val writeoffs: List<Writeoff>,
)
