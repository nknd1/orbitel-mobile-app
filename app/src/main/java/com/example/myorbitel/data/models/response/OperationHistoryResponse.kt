package com.example.myorbitel.data.models.response

import com.example.myorbitel.data.models.Deposit
import com.example.myorbitel.data.models.Writeoff
import com.google.gson.annotations.SerializedName

data class OperationHistoryResponse(
    @SerializedName("deposits")
    val deposits: List<Deposit>,
    @SerializedName("writeoffs")
    val writeoffs: List<Writeoff>,
)
