package com.example.myorbitel.models

data class Deposit(
    val deposit_id: Int,
    val date_deposits: String,
    val time_deposits: String,
    val amount: Double,
    val contractId: Int,
)
