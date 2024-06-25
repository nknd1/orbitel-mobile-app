package com.example.myorbitel.models

data class ClientInfo(
    val client_id: Int,
    val client_address_registration: String,
    val client_fio: String,
    val client_phone: String,
    val client_type: String,
)
