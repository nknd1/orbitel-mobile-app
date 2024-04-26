package com.example.myorbitel.models

import com.google.gson.annotations.SerializedName

data class Auth(
    @SerializedName("personal_account")
    val personal_account: String,
    val password: String
)
