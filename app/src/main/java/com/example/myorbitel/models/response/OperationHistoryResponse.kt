package com.example.myorbitel.models.response

import com.example.myorbitel.models.Deposit
import com.example.myorbitel.models.Writeoff
import com.google.gson.annotations.SerializedName

data class OperationHistoryResponse(
    @SerializedName("deposits")
    val deposits: List<Deposit>,
    @SerializedName("writeoffs")
    val writeoffs: List<Writeoff>,
)
