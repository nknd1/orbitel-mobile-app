package com.example.myorbitel.models

data class Writeoff(
    val id: Int,
    val date: String,
    val time: String,
    val amount: Double,
    val reason: String,
    val contractId: Int
)


data class Deposit(
    val id: Int,
    val date: String,
    val time: String,
    val amount: Double,
    val contractId: Int
)

sealed class Transaction {
    data class WriteOffTransaction(val writeoff: Writeoff) : Transaction()
    data class DepositTransaction(val deposit: Deposit) : Transaction()
}