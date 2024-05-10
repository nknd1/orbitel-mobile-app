package com.example.myorbitel.models

data class ContractInformation(
    val contract_id: Int,
    val connect_address: String,
    val balance: String,
    val contract_number: String,
    val personal_account: String,
    val tariff_name: String,
    val price_per_month: String,
    val speed: String,
    val client_fio: String,
    val client_phone: String,
    val client_address_registration: String,
)
