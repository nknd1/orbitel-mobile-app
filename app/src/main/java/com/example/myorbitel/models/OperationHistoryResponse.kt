package com.example.myorbitel.models

data class OperationHistoryResponse(
    val deposits: List<Deposit>,
    val writeoffs: List<Writeoff>,
)
