package com.example.myorbitel.models

import com.google.gson.annotations.SerializedName

data class ClientInfo(
    @SerializedName("client_id")
    val client_id: Int,
    @SerializedName("client_address_registration")
    val client_address_registration: String,
    @SerializedName("client_fio")
    val client_fio: String,
    @SerializedName("client_phone")
    val client_phone: String,
    @SerializedName("client_type")
    val client_type: String,
)
