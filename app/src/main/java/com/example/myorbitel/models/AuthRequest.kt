package com.example.myorbitel.models

import com.google.gson.annotations.SerializedName

data class AuthRequest(
    @SerializedName("client_phone")
    val client_phone: String,
    @SerializedName("password")
    val password: String,
)
