package com.example.myorbitel.models

data class WriteOff(
    val id: Int,
    val date: String,
    val time: String,
    val amount: Double,
    val reason: String,
    val contractId: Int
)
