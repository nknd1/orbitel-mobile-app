package com.example.myorbitel.data.models

data class Writeoff(
    val writeoff_id: Int,
    val date_writeoffs: String,
    val time_writeoffs: String,
    val amount: Double,
    val reason: String,
    val contractId: Int,
)
